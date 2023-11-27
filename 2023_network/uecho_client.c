// UDP Echo Client

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
	
	if(argc != 3) {
		printf("Usage: %s <port>\n", argv[0]);
		exit(1);
	}
	
	if((sockFd = socket(PF_INET, SOCK_DGRAM, 0)) <0)
		handle_error("socket() error.");
		
	memset(&serverAddress, 0, sizeof(serverAddress));
	serverAddress.sin_family = AF_INET;
	//serverAddress.sin_addr.s_addr = inet_addr(argv[1]);
	if(!inet_pton(AF_INET, argv[1], &serverAddress.sin_addr))
		handle_error("inet_pton() error.");
	serverAddress.sin_port = htons(atoi(argv[2]));
	
		
	for( ; ; ) {
		fputs("Type a message (Q/q to quit): ", stdout);
		fgets(buffer, BUFFER_SIZE, stdin);
		
		if(!strcmp(buffer, "Q\n") || !strcmp(buffer, "q\n"))
			break;
		
		if(sendto(sockFd, buffer, strlen(buffer), 0, (struct sockaddr *)&serverAddress, sizeof(serverAddress)) < 0)
			handle_error("sendto() error.");
		
		clientAddressLen = sizeof(clientAddress);
		if((nRecv = recvfrom(sockFd, buffer, BUFFER_SIZE, 0, (struct sockaddr *)&clientAddress, &clientAddressLen)) < 0)
			handle_error("recvfrom() error.");
		
		buffer[nRecv] = 0; // Necessary for prinf()
		printf("Message received from server: %d bytes, %s", nRecv, buffer);
		
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

