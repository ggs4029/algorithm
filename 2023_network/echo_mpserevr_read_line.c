#include "mylib2.h"
#include <signal.h>
#include <sys/wait.h>

#define BUFFER_SIZE 1024

void wait_childproc(int);

int main(int argc, char *argv[])
{
	int listenFd;
	int connFd;
	struct sockaddr_in serverAddress, clientAddress;
	socklen_t clientAddressLen;
	pid_t pid; // fork() 하기 위한 pid_t속성의 변수 pid
	struct sigaction act; // sigaction구조체 act
	
	char buffer[BUFFER_SIZE];
	int nRead;
	
	if(argc != 2) {
		printf("Usage: %s <port>\n", argv[0]);
		exit(1);
	}
	
	act.sa_handler = wait_childproc; // wait_childproc함수를 등록.
	sigemptyset(&act.sa_mask);
	act.sa_flags = 0;
	
	if(sigaction(SIGCHLD, &act, 0) < 0)
		handle_error("sigaction() error.");
	
	listenFd = generate_tcp_listen_socket(atoi(argv[1]));
	
	for( ; ; ) {
		clientAddressLen = sizeof(clientAddress);
		if((connFd = accept(listenFd, (struct sockaddr*)&clientAddress, &clientAddressLen)) < 0)
			if(errno == EINTR)
				continue;
			else
				handle_error("accept() error");
				
		if((pid = fork()) == -1) {
			close(connFd);
			continue; // handle_error("fork() error.");
		} else if(pid == 0) { // child process
			close(listenFd);
			for( ; ; ) {
				if((nRead = read_line(connFd, buffer, BUFFER_SIZE)) < 0)
					handle_error("read_line() error.");
				else if(nRead == 0)
					break;
					
				buffer[nRead] = 0; // Necessary for printf()
				printf("Message received from client: %d bytes, %s", nRead, buffer);
				if(write_n(connFd, buffer, nRead) < 0)
					handle_error("write_n() error.");
			}
		}
		close(connFd);
		
		exit(0);
	}
	
	close(listenFd);
	return 0;	
}

void wait_childproc(int signo) {
	int status;
	pid_t pid;
	
	while((pid = waitpid(-1, &status, WNOHANG)) > 0) { // 2
		if(WIFEXITED(status)) {
			printf("Waited child PID: %d\n", pid);
			printf("Waited child exit status: %d\n", WEXITSTATUS(status));
		}
	}
}






