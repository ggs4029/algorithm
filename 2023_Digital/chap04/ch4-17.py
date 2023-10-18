# 파일명: ch4-17.py
# 작성자: 김승욱
# 내용: pc 카메라를 통해 받아온 프레임을 좌우로 뒤집어
#       flip_test.avi 이름의 동영상 파일로 저장하는 프로그램

import cv2

capture = cv2.VideoCapture(0)                       # 0번 카메라 연결
if capture.isOpened() == False: raise Exception("카메라 연결 안됨")

fps = 15                                            # 초당 프레임 수
delay = round(1000/ fps)                            # 프레임 간 지연 시간
size  = (640, 480)                                  # 동영상 파일 해상도
fourcc = cv2.VideoWriter_fourcc(*'DIVX')            # Divx로 압축 코덱 설정

# 카메라 속성 콘솔창에 출력
print("프레임 해상도:", size )
print("압축코덱 숫자:", fourcc)
print("delay: %2d ms" % delay)
print("fps: %.2f" % fps)

# 동영상 파일 개방 및 코덱, 해상도 설정
writer = cv2.VideoWriter("flip_test.avi", fourcc, fps, size)
if writer.isOpened() == False: raise Exception("동영상 파일 개방 안됨")

while True:
    ret, frame = capture.read()             # 카메라 영상 받기
    if not ret: break
    if cv2.waitKey(delay) >= 0: break

    reFrame = cv2.flip(frame,1)   # 프레임 좌우로 뒤집기
    writer.write(reFrame)                 # 프레임을 동영상으로 저장
    cv2.imshow("ch4-17", reFrame)

writer.release()
capture.release()