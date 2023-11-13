#include "mylib2.h"

int generate_tcp_listen_socket(unsigned short serverPort)
{
	int listenFd;
	struct sockaddr_in serverAddress;

	if((listenFd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
		handle_error("socket() error.");

	memset(&serverAddress, 0, sizeof(serverAddress));
	serverAddress.sin_family = AF_INET;
	serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);
	serverAddress.sin_port = htons(serverPort);

	if(bind(listenFd, (struct sockaddr *)&serverAddress, sizeof(serverAddress)) < 0)
		handle_error("bind() error");

	if(listen(listenFd, 5) < 0)
		handle_error("listen() error.");

	return listenFd;
}

int generate_tcp_client_socket(const char *serverIp, unsigned short serverPort)
{
	int sockFd;
	struct sockaddr_in serverAddress;
//	struct hostent *hostPtr;

	if((sockFd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
		handle_error("socket() error.");

	memset(&serverAddress, 0, sizeof(serverAddress));
	serverAddress.sin_family = AF_INET;
//	hostPtr = gethostbyname(SERVER_NAME);
//	serverAddress.sin_addr = *(struct in_addr *)hostPtr->h_addr_list[0];
	if(!inet_pton(AF_INET, serverIp, &serverAddress.sin_addr))
		handle_error("inet_pton() error.");
	serverAddress.sin_port = htons(serverPort);

	if(connect(sockFd, (struct sockaddr *)&serverAddress, sizeof(serverAddress)) < 0)
		handle_error("connect() error.");

	return sockFd;
}

ssize_t read_n(int fd, void *vptr, size_t n)
{
	size_t nleft;
	ssize_t nread;
	char *ptr;

	ptr = vptr;
	nleft = n;
	while(nleft > 0) {
		if((nread = read(fd, ptr, nleft)) < 0) {
			if(errno == EINTR)
				nread = 0;
			else
				return(-1); 
		} else if(nread == 0)
			break;

		nleft -= nread;
		ptr += nread;
	}

	return(n - nleft);
}

ssize_t write_n(int fd, const void *vptr, size_t n)
{
	size_t nleft;
	ssize_t nwritten;
	const char *ptr;

	ptr = vptr;
	nleft = n;
	while(nleft > 0) {
		if((nwritten = write(fd, ptr, nleft)) <= 0) {
			if(errno == EINTR)
				nwritten = 0;
			else
				return(-1);
		}
		nleft -= nwritten;
		ptr += nwritten;
	}

	return(n);
}

ssize_t read_line(int fd, void *vptr, size_t maxlen)
{
	ssize_t n, rc;
	char c, *ptr;

	ptr = vptr;
	for(n = 1; n < maxlen; n++) {
		again:
		if((rc = read(fd, &c, 1)) == 1) {
			*ptr++ = c;
			if(c == '\n')
				break;  /* newline is stored, like fgets() */
		} else if(rc == 0) {
			if(n == 1)
				return(0);  /* EOF, no data read */
			else
				break;      /* EOF, some data was read */
		} else {
			if(errno == EINTR)
				goto again;
			return(-1);     /* error, errno set by read() */
		}
	}

	*ptr = 0;   /* null terminate like fgets() */

	return(n);
}

void handle_error(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}

