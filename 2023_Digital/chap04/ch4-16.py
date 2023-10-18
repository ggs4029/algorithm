# 파일명: ch4-16.py
# 작성자: 김승욱
# 내용: pc 카메라를 통해 받아온 프레임에
#       (200,100) 좌표에서 100X200 크기의 관심 영역 지정,
#       관심 영역에서 녹색 성분을 50만큼 증가,
#       관심 영역의 테두리를 두께 3의 빨간색으로 표시 하고
#       결과 영상을 윈도우에 표시하는 프로그램

import cv2

capture = cv2.VideoCapture(0) # 카메라 연결
if capture.isOpened() is None: raise Exception("카메라 연결 안됨")

while True:
    ret, frame = capture.read()  # 카메라 영상 받기
    if not ret: break
    if cv2.waitKey(30) >= 0: break # 종료 조건은 스페이스바 키

    x, y = 200, 100
    width, height = 100, 200 # 관심 영역의 크기
    rec = frame[y:y+height, x:x+width] # 관심 영역을 rec변수로
    rec[:, :, 1] = cv2.add(rec[:, :, 1], 50) # 녹색 성분 50 증가

    cv2.rectangle(frame, (x, y), (x + width, y + height), (0, 0, 255), 3)  # 빨간색 테두리 그리기
    cv2.imshow("ch4-16", frame)

    if cv2.waitKey(1) == 27: break  # ESC 키를 누르면 종료

capture.release()
cv2.destroyAllWindows()