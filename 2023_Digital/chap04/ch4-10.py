# 파일명: ch4-10.py
# 작성자: 김승욱
# 작성일: 2023.09.24
# 내용: 마우스 왼쪽 버튼을 누르면 크기 (30,30)의  빨간 사각형을 그리고
#       오른쪽 버튼을 누르면 클릭 좌표에서 반지름이 20화소인 파란 원을 그리는
#       이벤트 제어 프로그램

import numpy as np
import cv2

def onMouse(event, x, y, flags, param):
    global title, pt                            # 전역 변수 참조
    # 사각형 그리기
    if event == cv2.EVENT_LBUTTONDOWN:
        pt = (x, y)                         # 시작 좌표 지정
        cv2.rectangle(image, pt, (x+30, y+30), (0, 0, 255), 2) # 30X30 빨간 사각형 그림
        cv2.imshow(title, image) # 영상 표시
    # 원 그리기
    elif event == cv2.EVENT_RBUTTONDOWN:
        pt = (x, y) # 시작 좌표 지정
        radius = 20 # 반지름은 20화소
        cv2.circle(image, pt, radius, (255, 0, 0), 2) # 반지름이 20화소인 파란 원을 그림
        cv2.imshow(title, image) # 영상 표시

image = np.full((600, 600, 3), (255, 255, 255), np.uint8) # 흰색 영상

pt = (-1, -1) # 시작 좌표 초기화
title = "ch4-10"
cv2.imshow(title, image) # 영상 표시
cv2.setMouseCallback(title, onMouse) # 마우스 콜백 함수 등록
cv2.waitKey(0)
