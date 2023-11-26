#include "mylib.h"

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


