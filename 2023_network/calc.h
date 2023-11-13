#define BUFFER_SIZE	1024

#pragma pack(push)
#pragma pack(1)
typedef struct {
	int8_t numOperand;
	int8_t operator;
//	int testElement; // sizeof(CALC_REQ_HDR_t): 8
} CALC_REQ_HDR_t;

typedef struct {
	int32_t answer;
} CALC_RESP_t;
#pragma pack(pop)

