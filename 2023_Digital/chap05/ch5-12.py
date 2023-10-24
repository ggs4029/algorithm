# 파일명: ch5-11.py
# 작성자: 김승욱
# 내용: 영상 파일을 읽어 메인 윈도우에 다음과 같이 출력하기.
#       메인 윈도우의 특정 부분 2곳을 관심 영역으로 지정하고
#       관심 영역1은 영상의 밝기를 50만큼 밝게 한다.
#       관심 영역2는 영상의 화소대비를 증가시킨다.

import numpy as np
import cv2

image = cv2.imread("images/color.jpg", cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상파일 읽기 오류")

# 관심 영역1 설정
r1_x, r1_y, r1_width, r1_height = 200, 20, 150, 150
r1 = image[r1_y:r1_y+r1_height, r1_x:r1_x+r1_width]
# 관심 영역2 설정
r2_x, r2_y, r2_width, r2_height = 200, 180, 100, 100
r2 = image[r2_y:r2_y+r2_height, r2_x:r2_x+r2_width]

# 관심 영역1 밝기 조절
brightness = 50
r1 = cv2.add(r1, brightness)
# 관심 영역2 화소대비 증가
r2 = cv2.equalizeHist(r2)

# 원본 이미지에 다시 적용
image[r1_y:r1_y+r1_height, r1_x:r1_x+r1_width] = r1
image[r2_y:r2_y+r2_height, r2_x:r2_x+r2_width] = r2

cv2.imshow("ch5-12", image)
cv2.waitKey(0)
cv2.destroyAllWindows()