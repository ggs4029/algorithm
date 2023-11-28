// UDP Echo Server

#include "mylib.h"

#define BUFFER_SIZE 512

void handle_error(char *);

int main(int argc, char *argv[])
{
	int sockFd;
	struct sockaddr_in serverAddress, clientAddress;
	socklen_t clientAddressLen;
	
	char buffer[BUFFER_SIZE];
	int nRecv;
	
	if(argc != 2) {
		printf("Usage: %s <port>\n", argv[0]);
	}
	
	if((sockFd = socket(PF_INET, SOCK_DGRAM, 0)) <0)
		handle_error("socket() error.");
		
	memset(&serverAddress, 0, sizeof(serverAddress));
	serverAddress.sin_family = AF_INET;
	serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);
	serverAddress.sin_port = htons(atoi(argv[1]));
	
	if(bind(sockFd, (struct sockaddr *)&serverAddress, sizeof(serverAddress)) < 0)
		handle_error("bind() error");
		
	for( ; ; ) {
		clientAddressLen = sizeof(clientAddress);
		if((nRecv = recvfrom(sockFd, buffer, BUFFER_SIZE, 0, (struct sockaddr *)&clientAddress, &clientAddressLen)) < 0)
			handle_error("recvfrom() error.");
		
		buffer[nRecv] = 0; // Necessary for prinf()
		printf("Message received from client: %d bytes, %s", nRecv, buffer);
		
		if(sendto(sockFd, buffer, nRecv, 0, (struct sockaddr *)&clientAddress, clientAddressLen) < 0)
			handle_error("sendto() error.");
	}
	
	close(sockFd);
	
	return 0;
}

void handle_error(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}

