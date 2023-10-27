# 파일명: ch5-15.py
# 작성자: 김승욱
# 내용: 예제를 수정하여 사각형의 중심점을 기준으로 45도 회전시키는 프로그램.

import numpy as np, cv2

pts1 = np.array([(100, 90, 1), (400, 90, 1),
                 (400, 250, 1), (100, 250, 1)], np.float32)

theta = 45 * np.pi / 180

m = np.array([ [np.cos(theta),-np.sin(theta),0],
               [np.sin(theta),np.cos(theta),0],
               [0,0,1]], np.float32)

# 중심좌표 계산
delta = (pts1[2] - pts1[0])//2
center = pts1[0] + delta

t1 = np.eye(3, dtype=np.float32)
t2 = np.eye(3, dtype=np.float32)

# 중심좌표 평행 이동
t1 = np.array([[1, 0, -center[0]],
               [0, 1, -center[1]],
               [0, 0, 1]], np.float32)
# 회전변환 행렬
rotate_pts1 = np.array([[np.cos(theta), -np.sin(theta), 0],
                            [np.sin(theta), np.cos(theta), 0],
                            [0, 0, 1]], np.float32)
# 중심점 다시 이동
t2 = np.array([[1, 0, center[0]],
               [0, 1, center[1]],
               [0, 0, 1]], np.float32)

pts2 = np.dot(t2, np.dot(rotate_pts1, np.dot(t1, pts1.T))).T

for i, (pt1, pt2) in enumerate(zip(pts1, pts2)):
    print("pts1[%d] = %s, pst2[%d]= %s" %(i, pt1, i, pt2))

## 영상 생성 및 4개의 좌표 그리기
image = np.full((400, 500, 3), 255, np.uint8)
cv2.polylines(image, [np.int32(pts1[:, :2])], True, (0, 255, 0), 2)
cv2.polylines(image, [np.int32(pts2[:, :2])], True, (255, 0, 0), 3)
cv2.imshow("ch5-15", image)
cv2.waitKey(0)