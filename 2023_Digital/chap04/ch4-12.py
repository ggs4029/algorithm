# 파일명: ch4-12.py
# 작성자: 김승욱
# 내용: 05.event_trackbar.py 에서
#       화살표 키로 트랙바를 이동하는 코드를 추가한 프로그램
#       왼쪽, 오른쪽, 위, 아래 네개의 키가 전부 사용 가능하도록 만들었다.

import numpy as np
import cv2

def onChange(value):
    global image, title

    add_value = value - int(image[0][0])
    print("추가 화소값:", add_value)
    image[:] = image + add_value
    cv2.imshow(title, image)

image = np.zeros((300,500), np.uint8)

title = "ch4-12"
cv2.imshow(title, image) # 영상 표시
cv2.createTrackbar('Brightness', title, image[0][0], 255, onChange) # 트랙바 등록
while True:	# 무한 반복
    key = cv2.waitKeyEx(100) # 100ms 동안 키 이벤트 대기
    if key == 27: break # ESC 키 누르면 종료
    elif key == 2424832 or key == 2621440: # 왼쪽이나 아래 화살표를 누르면 화소값이 감소
        trackbar = cv2.getTrackbarPos('Brightness', title) # 트랙바의 현재 위치
        cv2.setTrackbarPos('Brightness', title, trackbar-1) # 슬라이더 위치에서 -1
    elif key == 2555904 or key == 2490368: # 오른쪽이나 위 화살표를 누르면 화소값이 증가
        trackbar = cv2.getTrackbarPos('Brightness', title)  # 트랙바의 현재 위치
        cv2.setTrackbarPos('Brightness', title, trackbar + 1)  # 슬라이더 위치에서 +1