# 파일명: ch4-10.py
# 작성자: 김승욱
# 작성일: 2023.09.24
# 내용: (600,400) 크기의 윈도우를 만들고 (100,100) 좌표에
#       200X300 크기의 빨간색 사각형을 그리는 프로그램

import numpy as np
import cv2

red = (0,0,255) # 색상(빨간색) 선언
image = np.zeros((600,400,3), np.uint8) # 3채널 컬러 영상 생성
image[:] = (255,255,255) # 3채널을 흰색으로 지정

# 사각형 그리기
pt1, pt2 = (100,100), (300,400) # 사각형의 좌표
cv2.rectangle(image, pt1, pt2, red, cv2.FILLED) # 사각형 내부 채움

title = 'ch4-9'
cv2.imshow(title, image) # 영상 표시
cv2.waitKey(0)
cv2.destroyAllWindows()