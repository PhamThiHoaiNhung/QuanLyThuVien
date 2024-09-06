-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table quanlythuvien.sach: ~21 rows (approximately)
REPLACE INTO `sach` (`maSach`, `tenSach`, `tacGia`, `theLoai`, `tinhTrang`) VALUES
	(1, 'Mao chủ tịch ngữ lục', 'Mao Trạch Đông', 'Sách', 0),
	(2, 'Don Quixote', 'Miguel de Cervantes', 'Truyện giả tưởng', 0),
	(3, 'Harry Potter', 'J. K. Rowling', 'Truyện giả tưởng', 1),
	(4, 'Những cuộc phiêu lưu của Pinocchio', 'Carlo Collodi', 'Truyện giả tưởng', 0),
	(5, 'Harry Potter và Chiếc cốc lửa', 'J. K. Rowling', 'Truyện giả tưởng', 1),
	(6, 'Code dạo kí sự', 'Phạm Huy Hoàng', 'Sách tham khảo', 0),
	(7, 'Hành trang lập trình', 'Vũ Công Tấn Tài', 'Sách tham khảo', 1),
	(8, 'Lập trình Java căn bản', 'Phạm Văn Trung, Phạm Văn Tho ', 'Sách tham khảo', 0),
	(9, ' Bí Ẩn Chưa Lời Giải Về Mùa Mưa Rực Lửa', 'Phiên Đại Vương', 'Truyện trinh thám', 0),
	(10, 'Thính Thần', 'Cá Muối Không Ăn Rau', 'Truyện trinh thám', 0),
	(11, 'Mật mã Da Vinci', 'Dan Brown', 'Truyện trinh thám', 1),
	(12, 'Sherlock Holmes', 'Arthur Conan Doyle', 'Truyện trinh thám', 0),
	(13, 'Sự im lặng của bầy cừu', 'Thomas Harris', 'Truyện trinh thám', 0),
	(14, 'Án mạng trên sông Nile', 'Agatha Christie', 'Truyện trinh thám', 1),
	(15, 'Hỏa ngục', 'Dan Brown', 'Truyện trinh thám', 0),
	(16, 'Thú tội', 'Kanae Minato', 'Truyện trinh thám', 0),
	(17, 'Đi vào nghiên cứu khoa học', 'Nguyễn Văn Tuấn', 'Sách nghiên cứu', 0),
	(18, 'Nghiên cứu dịch thuật', 'Hoàng Văn Tuấn', 'Sách nghiên cứu', 1),
	(20, 'Tôi thấy hoa vàng trên cỏ xanh', 'Phạm Quốc Huy', 'Truyện', 0),
	(23, 'A', 'B', 'B', 0);

-- Dumping data for table quanlythuvien.taikhoan: ~2 rows (approximately)
REPLACE INTO `taikhoan` (`tenTaiKhoan`, `matKhau`) VALUES
	('a', '123'),
	('admin', 'admin'),
	('b', '123'),
	('huy', '123'),
	('test', '123');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
