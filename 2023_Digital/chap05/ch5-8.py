# 파일명: ch5-8.py
# 작성자: 김승욱
# 내용: 영상에서 타원 모양의 특정 영역을 복사하여 새 창에 표시하는 프로그램.

import numpy as np, cv2

# 영상 읽기
image = cv2.imread("images/color.jpg", cv2.IMREAD_COLOR)
if image is None: raise Exception("영상파일 읽기 오류")

# 타원 그리기
mask = np.zeros(image.shape[:2], np.uint8)
center = (190,170)  # 타원 중심 좌표
axes = (60,100)     # 타원의 x,y축 반지름
color = (255,255,255)     # 타원 색
cv2.ellipse(mask, center, axes, 0, 0, 360, color, -1)

# 타원 영역만 표시하기
dst = cv2.bitwise_and(image, image, mask=mask)

# 이미지 표시
cv2.imshow("image", image)
cv2.imshow("dst", dst)
cv2.waitKey()