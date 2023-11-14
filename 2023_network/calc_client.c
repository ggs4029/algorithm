// 계산기 클라이언트 프로그램
// 피연산자와 연산자를 입력 받아 서버로 보내고
// 계산 결과를 서버로부터 받아온 뒤 출력하는 프로그램.

#include "mylib2.h"
#include "calc.h"

int main(int argc, char *argv[])
{
	int sockFd;
	unsigned char buffer[BUFFER_SIZE];
	CALC_REQ_HDR_t calcReqHdr;
	CALC_RESP_t *calcRespPtr;
	int numOperand, operator;
	int32_t *operandPtr;
	int32_t operandTmp;
	int messageLen;
	unsigned char *message;
	int32_t answer;
	int i;
	
	if(argc != 3) {
		printf("Usage: %s <IP> <port>\n", argv[0]);
		exit(1);
	}
	
	sockFd = generate_tcp_client_socket(argv[1], atoi(argv[2]));
	
	printf("Connected to the calculating server.\n");
	
	printf("Number of operands: ");
	scanf("%d", &numOperand);
	calcReqHdr.numOperand = (int8_t)numOperand;
	fgetc(stdin);
	
	printf("Operator (+, -, *): ");
	scanf("%lc", &operator);
	calcReqHdr.operator = (int8_t)operator;
	
	printf("calcReqHdr.numOperand: %d\n", calcReqHdr.numOperand);
	printf("calcReqHdr.operator: %d %c\n", calcReqHdr.operator, calcReqHdr.operator);
	printf("sizeof(CALC_REQ_HDR_t): %ld\n", sizeof(CALC_REQ_HDR_t));
	
	operandPtr = (int32_t *)malloc(numOperand * sizeof(int32_t));
	for(i=0; i<numOperand; i++) {
		printf("Operand %d: ", i);
		scanf("%d", &operandTmp);
		operandPtr[i] = htonl(operandTmp);
	}
	
	messageLen = sizeof(CALC_REQ_HDR_t) + numOperand * sizeof(int32_t);
	message = (unsigned char *)malloc(messageLen * sizeof(unsigned char));
	
	memcpy(message, (unsigned char *)&calcReqHdr, sizeof(CALC_REQ_HDR_t));
	memcpy(message + sizeof(CALC_REQ_HDR_t), (unsigned char *)operandPtr, numOperand *sizeof(int32_t));
	
	printf("Message to Send: ");
	for(i=0; i<messageLen; i++)
		printf("%02X ", message[i]);
	printf("\n");
	
	write_n(sockFd, message, messageLen);
	
	if(read_n(sockFd, buffer, sizeof(CALC_RESP_t)) <= 0)
		handle_error("Server error.");
		
	printf("Message received: ");
	for(i=0; i<sizeof(CALC_RESP_t); i++) {
		printf("%02X ", buffer[i]);
	}
	printf("\n");
	
	calcRespPtr = (CALC_RESP_t *)buffer;
	answer = ntohl(calcRespPtr->answer);
	
	printf("Answer: %d\n", answer);
	
	free(operandPtr);
	free(message);
	close(sockFd);
	
	return 0;
	
}
