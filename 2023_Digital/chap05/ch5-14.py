# 파일명: ch5-14.py
# 작성자: 김승욱
# 내용: 연립방정식을 가우시안 소거법의 역함수를 이용해 해를 구하는 프로그램.

import numpy as np
import cv2

# 연립방정식의 계수들
data = [3,6,3,-5,6,1,2,-3,5]
# 계수들을 행렬로 생성
m1 = np.array(data, np.float32).reshape(3,3)
# 상수 벡터
m2 = np.array([2,10,28], np.float32)

# 역행렬 계산
ret, inv = cv2.invert(m1, cv2.DECOMP_LU)
if ret:
    #dst1 = inv.dot(m2)
    #dst2 = cv2.gemm(inv, m2, 1, None, 1)
    _ , dst3 = cv2.solve(m1,m2,cv2.DECOMP_LU)
    # 출력
    print("[inv] = \n%s\n" % inv)
    #print("[dst1] =", dst1.flatten())
    #print("[dst2] =", dst2.flatten())
    print("[dst3] =", dst3.flatten())
else:
    print("역행렬이 존재 x")