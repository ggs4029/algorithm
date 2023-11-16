// 계산기 서버 프로그램
// 클라이언트로부터 피연산자와 연산자를 받아
// 계산 후 출력, 클라이언트로 다시 보낸다.

#include "mylib2.h"
#include "calc.h"

int main(int argc, char *argv[])
{
	int connFd, listenFd;
	unsigned char buffer[BUFFER_SIZE];
	struct sockaddr_in serverAddress, clientAddress;
	socklen_t clientAddressLen;
	CALC_REQ_HDR_t *calcReqHdrPtr;
	uint8_t numOperand, operator;
	int32_t *operandPtr;
	int32_t answer;
	int messageLen;
	unsigned char *message;
	int i;
	
	if(argc != 2) {
		printf("Usage: %s <IP> <port>\n", argv[0]);
		exit(1);
	}
	
	listenFd = generate_tcp_listen_socket(atoi(argv[1]));
	
	for( ; ; ) {
		clientAddressLen = sizeof(clientAddress);
		if((connFd = accept(listenFd, (struct sockaddr *)&clientAddress, &clientAddressLen)) < 0)
			handle_error("accept() error.");
			
		if(read_n(connFd, buffer, sizeof(CALC_REQ_HDR_t)) <= 0) {
			close(connFd);
			continue;
		}
		
		calcReqHdrPtr = (CALC_REQ_HDR_t *)buffer;
		
		numOperand = calcReqHdrPtr->numOperand;
		operator = calcReqHdrPtr->operator;
		
		printf("numOperand: %d\n", numOperand);
		printf("operator: %d %c\n", operator, operator);
		
		if(read_n(connFd, buffer, numOperand*sizeof(int32_t)) <= 0) {
			close(connFd);
			continue;
		}
		
		printf("Message (operands) received: ");
		for(i=0; i<numOperand*sizeof(int32_t); i++)
			printf("%02X ", buffer[i]);
		printf("\n");
		
		operandPtr = (int32_t *)malloc(numOperand * sizeof(int32_t));
		for(i=0; i<numOperand; i++) {
			operandPtr[i] = ntohl(*(int32_t *)&buffer[i*sizeof(int32_t)]);
			printf("operandPtr[%d]: %d\n", i, operandPtr[i]);
		}
		answer = operandPtr[0];
		
		switch(operator) {
			case '+':
				printf("+ operation.\n");
				for(i=1; i<numOperand; i++)
					answer += operandPtr[i];
				break;
			case '-':
				printf("- operation.\n");
				for(i=1; i<numOperand; i++)
					answer -= operandPtr[i];
				break;
			case '*':
				printf("* operation.\n");
				for(i=1; i<numOperand; i++)
					answer *= operandPtr[i];
				break;
			default:
				printf("Unavailable operation.\n");
				break;
		}
		
		printf("answer: %d\n", answer);
		answer = htonl(answer);
		
		messageLen = sizeof(CALC_RESP_t);
		message = (unsigned char *)malloc(messageLen * sizeof(unsigned char));
		memcpy(message, (unsigned char *)&answer, messageLen);
		
		printf("Message to send: ");
		for(i=0; i<messageLen; i++)
			printf("%02X ", message[i]);
		printf("\n");
		printf("-----------------------------------\n");
		
		write_n(connFd, message, messageLen);
		
		free(operandPtr);
		close(connFd);
	}
	
	close(listenFd);
	
	return 0;
}

