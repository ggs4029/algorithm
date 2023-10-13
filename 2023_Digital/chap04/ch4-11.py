# 파일명: ch4-11.py
# 작성자: 김승욱
# 내용: ch4-10.py 에서
#       트랙바를 추가해 선의 굵기를 조절하고
#       트랙바를 하나 더 추가해 원의 반지름을 조절하는 프로그램

import numpy as np
import cv2

def onMouse(event, x, y, flags, param):
    global title, pt # 전역 변수 참조
    # 사각형 그리기
    if event == cv2.EVENT_LBUTTONDOWN:
        pt = (x, y) # 시작 좌표 지정
        cv2.rectangle(image, pt, (x+30, y+30), (0, 0, 255), thickness) # 30X30 빨간 사각형 그림
        cv2.imshow(title, image) # 영상 표시
    # 원 그리기
    elif event == cv2.EVENT_RBUTTONDOWN:
        pt = (x, y) # 시작 좌표 지정
        cv2.circle(image, pt, radius, (255, 0, 0), thickness) # 반지름이 20화소인 파란 원을 그림
        cv2.imshow(title, image) # 영상 표시

def onChange1(value):
    global thickness # 굵기를 전역 변수로 설정
    thickness = value

def onChange2(value):
    global radius # 원의 반지름을 전역 변수로 설졍
    radius = value

image = np.full((800, 600, 3), (255, 255, 255), np.uint8) # 흰색 영상

pt = (-1, -1) # 시작 좌표 초기화
thickness = 1 # 시작 굵기를 2로 초기화
radius = 20 # 시작 반지름을 20으로 초기화
title = "ch4-11"
cv2.imshow(title, image) # 영상 표시
cv2.setMouseCallback(title, onMouse) # 마우스 콜백 함수 등록
cv2.createTrackbar('thickness', title, thickness, 10, onChange1) # 트랙바 등록
cv2.createTrackbar('radius', title, radius, 50, onChange2) # 트랙바 등록2
cv2.waitKey(0)
