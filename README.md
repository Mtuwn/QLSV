# Bài tập lớn Java

## Giới thiệu và Form đăng nhập

- Bài tập lần này sẽ được chia làm 2 phần chính gồm:
    + Sinh viên, giáo viên 
    + Khảo thí(admin)
- Để truy cập vào từng phần tương ứng với từng đối tượng thì chúng ta sẽ đến với giao diện đăng nhập:

![image](https://hackmd.io/_uploads/ry18Fy1Dp.png)

- Sau khi nhập tên đăng nhập và mật khẩu chúng ta sẽ click vào tư cách mà chúng ta muốn đăng nhập vào, hệ thống sẽ báo về nếu thông tin đăng nhập không chính xác 

![image](https://hackmd.io/_uploads/HJloKJyP6.png)

- Còn khi thành công sẽ nhận được 1 dòng Message thông báo thành công

## Khảo Thí

- Sau khi đăng nhập với chức năng khảo thí, chúng ta vào được giao diện tương ứng với các quyền của admin. 

![image](https://hackmd.io/_uploads/H1LU31kv6.png)

- Giao diện được chia làm 4 phần như trên hình gồm 
    + 1 panel giới ghi tên tài khoản + thời gian thực của ngày hiện tại, thời gian và user này sẽ thay đổi theo thời gian và tên admin. 
    + 1 panel gồm label và 1 nút button để logout tài khoản
    +  1 panel là Menu gồm các chức năng và quyền hạn của 1 tài khoản khảo thí(admin) 
    +  Và 1 panel là chính chứa các panel chức năng sau khi chúng ta click vào 1 nút button bất kì của menu thì các panel con sẽ được xuất hiện

### Sinh viên và giáo viên
- Đến với nút button đầu tiên là "Xem danh sách sinh viên"

![image](https://hackmd.io/_uploads/SJuRA11D6.png)

Danh sách sinh viên sẽ được hiển thị theo từng chuyên ngành và tên lớp tùy thuộc vào các lựa chọn trên 2 combo box. Chúng ta cũng có thể xem thêm thôn tin chi tiết bằng cách click vào 1 sinh viên bất kì của bảng table và nội dung sẽ được hiển thi ngay bên cạnh:

![image](https://hackmd.io/_uploads/r1_zGl1v6.png)

- Bên cạnh đó admin cũng có các quyền như là thêm sửa xóa đối với sinh viên:
    + Đối với chức năng thêm sinh viên, đối với các lớp sinh viên là trống, khi đó ô input của Msv sẽ được hiển thị cho phép nhập mã sinh viên, và tất nhiên nó sẽ báo lỗi nếu mã sinh viên đã tồn tại. Đối với những lớp đã có sinh viên thì ô input này sẽ được ẩn đi và Msv sẽ được tự động tăng lên so với sinh viên có msv lớn nhất của từng lớp: VD: sinh viên cuối danh sách lớp là AT180249 thì khi thêm sinh viên tiếp theo sẽ có mã là AT180250. Bên cạnh đó các ô cũng đã được regex 1 phần để khi người dùng bỏ trống thông tin hoặc nhập thông tin không hợp lệ sẽ được báo lỗi 

![image](https://hackmd.io/_uploads/r1wVGlyD6.png)

Và khi thêm 1 tài khoản người dùng thì bên phía sinh viên sẽ được cung cấp 1 tài khoản với username là MSV và mật khẩu sẽ là ngày sinh của sinh viên được xử lí và bỏ đi các kí tự VD: 16/04/2003 thì passwd sẽ là 16042003

- Khi chúng ta click vào button sửa hoặc xóa thì sẽ nhận được 1 thông báo để báo cho người dùng biết đang thực hiện đổi chức năng:

![image](https://hackmd.io/_uploads/B1jZXxkw6.png)

- Khi đổi sang chức năng sửa xóa thì msv sẽ được hiển thị lại cho phép người dùng sửa và xóa theo mã sinh viên và ô này sẽ được ẩn đi nếu chúng ta quay lại chế độ thêm nếu danh sách không trống.

- Tiếp theo đến button thứ 2 `Xem danh sách sinh viên`

![image](https://hackmd.io/_uploads/HJyW8ekwT.png)

Cơ bản thì nó cũng tương tự như của sinh viên, nó chỉ được lược bổ đi các combo box như chuyên ngành và tên lớp và thanh vào bằng combo box chọn trình độ của giáo viên bên cạnh đó nó chỉ được thay đổi 1 vài thuộc tính

### Lớp

- Tiếp theo là đến button thứ 3`Lớp`

![image](https://hackmd.io/_uploads/HkU5AgkD6.png)

 - Ở màn hình giao diện này chúng ta có chức năng xem danh sách các lớp được sắp xếp theo chuyên ngành được hiển thi ở combo box. Chúng ta cũng có các chức năng thêm và xóa các lớp trong danh sách 

### Xem điểm 

- Button thư 4 `Xem điểm`

![image](https://hackmd.io/_uploads/Hy0NxWJw6.png)

Tại màn hình giao diện này sẽ là danh sách điểm của từng sinh viên theo từng môn học. Chúng ta có thể thay đổi danh sách bằng cách lựa chọn trên danh sách các môn học của combo box. Bên cạnh đó, khi muốn thay đổi điểm của từng sinh viên, chúng ta có thể click vào bảng table để lấy thông tin sinh viên, ngay lập tức thông tin sẽ được hiển thị ngay bên cạnh, mặc khác thì các thông tin sẽ chỉ được chỉnh sửa là điểm chuyên cần điểm giữa kỳ và điểm thi, các dữ liệu khác sẽ được khóa không cho người dùng thay đổi tại giao diện chức năng này. Và tất nhiên dữ liệu trống thì sẽ bị báo lỗi

### Môn học 

- Tiếp đến là button môn học 
![image](https://hackmd.io/_uploads/HkGKbWkP6.png)

Tại đây sẽ là danh sách các môn học, kèm theo đó là đó là các chức năng thêm sửa xóa.

### Lớp theo tên môn học

- Cuối cùng là button cuối cùng, khi click vào đây sẽ xuất hiện màn hình giao diện của chức năng thêm sinh viên vào các lớp của môn học VD: Lớp Toán A1, OOP,..

![image](https://hackmd.io/_uploads/SkouMZJw6.png)

- Tại đây người dùng sẽ có quyền add sinh viên vào các lớp, cũng như xóa sinh viên. Nó sẽ báo lỗi nếu như msv không tồn tại 


## Sinh viên và giáo viên

- Đăng nhập vào với tư cách là sinh viên(giáo viên) người dùng sẽ được chuyển hướng tới màn hình giao diện của sinh viên(giáo viên)

![image](https://hackmd.io/_uploads/ByfwUW1Pa.png)

![image](https://hackmd.io/_uploads/S1UO8WJvp.png)

- Tại màn hình giao diện này chúng ta sẽ được hiển thị các thông tin của người dùng có
- Bên cạnh đó chúng ta cũng có phần tiện ích mở rộng như:

    + Xem danh sách sinh viên toàn trường 

    ![image](https://hackmd.io/_uploads/rye7v-yvp.png)


    + Xem danh sách giáo viên toàn trường:

    ![image](https://hackmd.io/_uploads/SJ8rPWJDT.png)

    + Tra cứu điểm của sinh viên toàn trường: 

    ![image](https://hackmd.io/_uploads/r1cZuW1vT.png)
