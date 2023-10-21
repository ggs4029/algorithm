# 파일명: ch5-7.py
# 작성자: 김승욱
# 내용: 컬러 영상파일을 입력 받아 RGB의 3개 채널로 분리하고
#       각 채널을 컬러 영상을 윈도우에 표시하는 프로그램.

import numpy as np, cv2

# 로고 영상 읽기
logo = cv2.imread("images/logo.jpg", cv2.IMREAD_COLOR)
if logo is None: raise Exception("영상파일 읽기 오류")

# 채널 분리
blue, green, red = cv2.split(logo)

# 분리된 단일 채널들을 그 색만 남기고 다시 합성
blue_img = cv2.merge([blue,np.zeros_like(green),np.zeros_like(red)])
green_img = cv2.merge([np.zeros_like(blue),green,np.zeros_like(red)])
red_img = red = cv2.merge([np.zeros_like(blue),np.zeros_like(green),red])

# 이미지 표시
cv2.imshow("logo", logo)
cv2.imshow("blue_img", blue_img)
cv2.imshow("green_img", green_img)
cv2.imshow("red_img", red_img)
cv2.waitKey()