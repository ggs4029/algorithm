#include <iostream>
#include <vector>
#include <map>
using namespace std;

map<pair<int, int>, int> m;
int output, x, y, n;
vector<pair<int, int>> v;
pair<int, int> a, b;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    v.resize(n);
    // 입력
    for(int i=0; i<n; i++) {
        cin >> x >> y;
        v[i] = { x, y };
        m[{x, y}]++;
    }
    // 직사각형을 찾기 위한 두 점을 비교
    for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            a = v[i]; b = v[j];
            if (v[i].first == v[j].first || v[i].second == v[j].second)
                continue;
            // 나머지 두 점 확인
            if (m.find({ a.first, b.second }) != m.end() && m.find({ b.first, a.second }) != m.end())
                output++;
        }
    }
    // 출력
    cout << output / 2 << endl;
    return 0;
}