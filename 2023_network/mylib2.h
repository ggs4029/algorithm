#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>	
#include <arpa/inet.h>
#include <sys/socket.h>

#include <errno.h>

int generate_tcp_listen_socket(unsigned short);
int generate_tcp_client_socket(const char *, unsigned short);
ssize_t read_n(int, void *, size_t);
ssize_t write_n(int, const void *, size_t);
ssize_t read_line(int, void *, size_t);
void handle_error(char *);

