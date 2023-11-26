-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: instagram-app
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsa3hl9a6mu30dct1jnn2bwvem` (`post_id`),
  KEY `FKtamaoacctq4qpko6bvtv0ke1p` (`user_id`),
  CONSTRAINT `FKsa3hl9a6mu30dct1jnn2bwvem` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `FKtamaoacctq4qpko6bvtv0ke1p` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,'Tuyệt vời quá','2023-10-05 00:54:42.631030',1,1),(2,'Nói hay lắm nha','2023-10-07 00:54:42.631030',2,3),(3,'Dị đó hả','2023-10-09 00:54:42.631030',3,2),(4,'Tuyệt cú mèo','2023-10-15 00:54:42.631030',4,4),(5,'Quá dữ','2023-10-22 00:54:42.631030',5,2),(6,'hay hay hay','2023-10-27 00:54:42.631030',6,3),(7,'OMG ','2023-11-03 00:54:42.631030',7,3),(8,'Hahaa','2023-11-07 00:54:42.631030',8,2),(9,'Quá trời','2023-11-07 00:54:42.631030',9,1),(10,'Chèn ạ','2023-11-08 00:54:42.631030',10,2),(11,'Ôi thật là vi diệu','2023-11-12 00:54:42.631030',1,3),(12,'What the have?','2023-11-12 00:54:42.631030',2,2),(13,'Yeahhhh','2023-11-03 00:54:42.631030',3,1),(14,'Okela','2023-10-22 00:54:42.631030',4,2),(15,'Yes sure','2023-11-12 00:54:42.631030',5,4),(16,'Là sao ta','2023-10-09 00:54:42.631030',6,3);
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_image`
--

DROP TABLE IF EXISTS `t_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_uri` longtext,
  `post_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmann4ws0hoqymubshgpqt5snn` (`post_id`),
  CONSTRAINT `FKmann4ws0hoqymubshgpqt5snn` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_image`
--

LOCK TABLES `t_image` WRITE;
/*!40000 ALTER TABLE `t_image` DISABLE KEYS */;
INSERT INTO `t_image` VALUES (1,'https://sudospaces.com/karofi-com/karofi/images/uploads/images/Nguoi%20truong%20thanh/truongthanhkhinao.jpg',1),(2,'https://timo.vn/wp-content/uploads/tien-la-gi-thumb.jpeg',2),(3,'https://tinnhanhplus.com/wp-content/uploads/2021/05/quan-tam-nguoi-yeu-khi-bi-om.jpg',3),(4,'https://product.hstatic.net/200000271525/product/o1cn01xhvwra1vux4gemzze___3533072657__1__133de3aeacb542bcb327885705588a68_master.jpg',4),(5,'https://image.voh.com.vn/voh/Image/2022/04/20/ca-khia-la-gi-vohcomvn.jpg?t=o&w=800&q=85',5),(6,'https://reviewchat.com.vn/wp-content/uploads/2021/07/ban-linh-dan-ong-elleman-2.jpg',6),(7,'https://vuanem.com/blog/wp-content/uploads/2022/11/tinh-yeu-thuong-la-gi.jpg',7),(8,'https://www.vietnamfineart.com.vn/wp-content/uploads/2023/03/hinh-anh-con-gai-cute-de-thuong-cute-anime-hoat-hinh-xinh-5.jpg',8),(9,'https://kenh14cdn.com/k:thumb_w/600/A3YmnWqkHeph7OwGyu6TwbX57tgTw/Image/2013/12/12B/Untitled-a6ba4/cuoi-cot-cung-co-the-gay-ra-tac-hai-khong-ngo.jpg',9),(10,'https://genpartners.genvita.vn/-/media/an-uong-khoa-hoc-2.ashx?h=450&w=800&la=en&hash=273BD66F0C154FDD8B78B71BB6583AEE8887F08D',10),(11,'https://demoda.vn/wp-content/uploads/2022/02/hinh-doc-than-buon-411x600.jpg',NULL),(12,'https://mega.com.vn/media/news/2009_hinh-nen-chill-cho-dien-thoai41.jpg',NULL),(13,'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2021/03/filter-instagram-dep-dung-cho-du-lich-6.jpg',NULL),(14,'https://toigingiuvedep.vn/wp-content/uploads/2022/05/anh-vintage-buon.jpg',NULL);
/*!40000 ALTER TABLE `t_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_message`
--

DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `user_id_receive` bigint DEFAULT NULL,
  `user_id_send` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1hy1fr12rpofmr45cgsqqt49n` (`user_id_receive`),
  KEY `FKak1vuubqhpt6vl6hm092m3sv4` (`user_id_send`),
  CONSTRAINT `FK1hy1fr12rpofmr45cgsqqt49n` FOREIGN KEY (`user_id_receive`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKak1vuubqhpt6vl6hm092m3sv4` FOREIGN KEY (`user_id_send`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_message`
--

LOCK TABLES `t_message` WRITE;
/*!40000 ALTER TABLE `t_message` DISABLE KEYS */;
INSERT INTO `t_message` VALUES (1,'M đang làm gì thế','2023-11-24 00:54:42.631030',1,3),(2,'Ê làm bài xong chưa','2023-11-24 00:55:42.631030',1,2),(3,'Đang rãnh nè có gì không','2023-11-24 00:57:42.631030',3,1),(4,'Định hỏi m làm bài sao á, chỉ t với','2023-11-24 01:02:42.631030',1,3),(5,'Có làm được đâu, bài khó quá','2023-11-24 01:05:42.631030',2,1),(6,'Haizz t đang hỏi thằng 3 xem làm sao nè','2023-11-24 01:15:42.631030',1,2),(7,'Oke hỏi xem có gì báo t','2023-11-24 01:17:42.631030',2,1),(8,'Bài hồi chiều cần phải xem hướng dẫn của thầy','2023-11-24 01:25:42.631030',3,1),(9,'Rồi chọn lọc cho kĩ vào','2023-11-24 01:30:42.631030',3,1),(10,'Tìm ra thừa số chung, từ đó suy ra kết quả','2023-11-24 01:37:42.631030',3,1),(11,'ủa vậy hả','2023-11-24 01:45:42.631030',1,3),(12,'Để t nghiên cứu thử xem như nào','2023-11-24 01:50:42.631030',1,3),(13,'Cảm ơn m nhá','2023-11-24 01:54:42.631030',1,3),(14,'Hong có chi','2023-11-24 03:51:54.232813',3,1),(15,'Oke ông =))))','2023-11-24 03:52:22.514781',1,3),(16,'Ê mày','2023-11-24 03:53:26.762670',1,2),(17,'Hello','2023-11-24 04:25:30.439138',3,2),(18,'hee','2023-11-24 04:30:28.802470',1,2),(20,'Còn thức hong Luân','2023-11-24 05:08:42.541229',1,2);
/*!40000 ALTER TABLE `t_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_post`
--

DROP TABLE IF EXISTS `t_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `likes` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK18f01t655nkcuptq9oxp04sgn` (`user_id`),
  CONSTRAINT `FK18f01t655nkcuptq9oxp04sgn` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_post`
--

LOCK TABLES `t_post` WRITE;
/*!40000 ALTER TABLE `t_post` DISABLE KEYS */;
INSERT INTO `t_post` VALUES (1,'Càng lớn tôi càng nhận ra là tôi không còn nhỏ nữa.','2023-10-05 00:54:42.631030',35,1),(2,'Tiền là giấy. Thấy là lấy.','2023-10-07 00:54:42.631030',250,4),(3,'Yêu hoài ốm, ôm hoài yếu','2023-10-09 00:54:42.631030',555,3),(4,' Thân em như hoa trên cành, hoa thì dễ rụng, em thì dễ thương.','2023-10-15 00:54:42.631030',432,3),(5,'Cà khịa một chút thì vui, cà khịa nhiều chút thì vui nhiều lần.','2023-10-22 00:54:42.631030',22,1),(6,' Cuộc đời như bản nonstop. Anh non thì em stop.','2023-10-27 00:54:42.631030',345,2),(7,'Chán cảnh yêu xa ghê, mình ở Việt Nam, còn anh ấy ở bên người khác.','2023-11-03 00:54:42.631030',1112,1),(8,'Em chỉ là một cô gái bình thường. Ăn hay không ăn đều do buồn.','2023-11-07 00:54:42.631030',3541,4),(9,'Cuộc sống vốn ngắn ngủi, vì vậy bạn hãy cười thật nhiều khi còn có răng.','2023-11-08 00:54:42.631030',4432,2),(10,'Thà mập mà được ăn ngon còn hơn nhịn ăn mà vẫn mập như thường.','2023-11-12 00:54:42.631030',2411,3);
/*!40000 ALTER TABLE `t_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_post_comments`
--

DROP TABLE IF EXISTS `t_post_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_post_comments` (
  `post_id` bigint NOT NULL,
  `comments_id` bigint NOT NULL,
  UNIQUE KEY `UK_1owyrkcq867758vpehiwtd32c` (`comments_id`),
  KEY `FK48ibtla0cmc2767tcfyc0gwpc` (`post_id`),
  CONSTRAINT `FK48ibtla0cmc2767tcfyc0gwpc` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `FKpggw8b1ifxfi9g6jlk3n4k1lr` FOREIGN KEY (`comments_id`) REFERENCES `t_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_post_comments`
--

LOCK TABLES `t_post_comments` WRITE;
/*!40000 ALTER TABLE `t_post_comments` DISABLE KEYS */;
INSERT INTO `t_post_comments` VALUES (1,1),(1,11),(2,2),(2,12),(3,3),(3,13),(4,4),(4,14),(5,5),(5,15),(6,6),(6,16),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `t_post_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_post_images`
--

DROP TABLE IF EXISTS `t_post_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_post_images` (
  `post_id` bigint NOT NULL,
  `images_id` bigint NOT NULL,
  UNIQUE KEY `UK_imcteg505le02y2lfo6uq3xpy` (`images_id`),
  KEY `FKc14x0a5c22lvvaipg0qdo12sb` (`post_id`),
  CONSTRAINT `FK4n9q4q65gv65hulogcwmlagtk` FOREIGN KEY (`images_id`) REFERENCES `t_image` (`id`),
  CONSTRAINT `FKc14x0a5c22lvvaipg0qdo12sb` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_post_images`
--

LOCK TABLES `t_post_images` WRITE;
/*!40000 ALTER TABLE `t_post_images` DISABLE KEYS */;
INSERT INTO `t_post_images` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `t_post_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_story`
--

DROP TABLE IF EXISTS `t_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_story` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `status_time` bit(1) NOT NULL,
  `image_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b7i3obtlklybf3vwdqqky6eh6` (`image_id`),
  KEY `FKnq5bettsub5dem9q3s5fvsiht` (`user_id`),
  CONSTRAINT `FKhh1rltbw41x8gewrk0t7scoal` FOREIGN KEY (`image_id`) REFERENCES `t_image` (`id`),
  CONSTRAINT `FKnq5bettsub5dem9q3s5fvsiht` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_story`
--

LOCK TABLES `t_story` WRITE;
/*!40000 ALTER TABLE `t_story` DISABLE KEYS */;
INSERT INTO `t_story` VALUES (1,'2023-11-24 05:08:10.258720',_binary '\0',11,1),(2,'2023-11-24 05:10:34.844845',_binary '\0',12,1),(3,'2023-11-24 05:10:34.844845',_binary '\0',1,2),(4,'2023-11-24 05:10:34.844845',_binary '\0',14,2);
/*!40000 ALTER TABLE `t_story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_story_view_stories`
--

DROP TABLE IF EXISTS `t_story_view_stories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_story_view_stories` (
  `story_id` bigint NOT NULL,
  `view_stories_id` bigint NOT NULL,
  UNIQUE KEY `UK_bgkrohwm72qfiict0br6rxwwo` (`view_stories_id`),
  KEY `FKgyjlq7j6atqiuxhvoqv8ffwtu` (`story_id`),
  CONSTRAINT `FKgyjlq7j6atqiuxhvoqv8ffwtu` FOREIGN KEY (`story_id`) REFERENCES `t_story` (`id`),
  CONSTRAINT `FKr0ous4x4mq3irhu7vkf6pjym1` FOREIGN KEY (`view_stories_id`) REFERENCES `t_view_story` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_story_view_stories`
--

LOCK TABLES `t_story_view_stories` WRITE;
/*!40000 ALTER TABLE `t_story_view_stories` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_story_view_stories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `follower` int DEFAULT NULL,
  `following` int DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `image_uri` longtext,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,5593,3,'Nguyễn Thành Luân','https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/297820843_740726907228784_3469292657821925944_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=Cwr6P0cqOUoAX-TLT-T&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfAH2Ag-asWK0ShdsQB2PDffR3Vsr37nKcqQMk9dKqcKag&oe=65651B00','Luân','luan','0396000730'),(2,15222,5,'Trần Quốc Trọng','https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/383463964_999213024647671_3064701886427668990_n.jpg?stp=cp6_dst-jpg&_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_ohc=fRN7Ez08xuEAX_OYBBh&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfAa6ZVF8RnlgZOrvu3PGVP1hxsryUsPVQdChDkF45Sliw&oe=6564A444','Trọng','trong','0357770753'),(3,2590,15,'Bùi Nhựt Duy','https://scontent.fsgn2-7.fna.fbcdn.net/v/t1.6435-9/120778724_997922344016885_3254601626065995900_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=dd63ad&_nc_ohc=AVza94rFhkoAX_HQTB_&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfCRlmoHecfjiIRWYDYbiXxE1ruFEVPpdJyo0gT6GKPNMw&oe=65872155','Duy','duy','3'),(4,3123,7,'Lương Viết Thanh','https://scontent.fsgn2-5.fna.fbcdn.net/v/t39.30808-6/256737324_1532431433774482_8005891580081015864_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=WwWOtJqYXvMAX8uVo43&_nc_ht=scontent.fsgn2-5.fna&oh=00_AfAkx6ICxioRWSmks_H6xebTH5k7joODNja_Fw9386JO1Q&oe=65641357','Thanh','thanh','4');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_posts`
--

DROP TABLE IF EXISTS `t_user_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_posts` (
  `user_id` bigint NOT NULL,
  `posts_id` bigint NOT NULL,
  UNIQUE KEY `UK_ownewgh5es0def3gkcq8pym64` (`posts_id`),
  KEY `FKlh22xppaw86orsbihdtf95fwf` (`user_id`),
  CONSTRAINT `FK5asj5kf95hd3ewbsu6stpi8jr` FOREIGN KEY (`posts_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `FKlh22xppaw86orsbihdtf95fwf` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_posts`
--

LOCK TABLES `t_user_posts` WRITE;
/*!40000 ALTER TABLE `t_user_posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_stories`
--

DROP TABLE IF EXISTS `t_user_stories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_stories` (
  `user_id` bigint NOT NULL,
  `stories_id` bigint NOT NULL,
  UNIQUE KEY `UK_evlg3vjvsfpy3vpofcwr7hntc` (`stories_id`),
  KEY `FK9076r4yvtf5ojc7lyaqqolkke` (`user_id`),
  CONSTRAINT `FK9076r4yvtf5ojc7lyaqqolkke` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKgo8wwk2ygdbwbsdn1bvsh2ym` FOREIGN KEY (`stories_id`) REFERENCES `t_story` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_stories`
--

LOCK TABLES `t_user_stories` WRITE;
/*!40000 ALTER TABLE `t_user_stories` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_stories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_view_story`
--

DROP TABLE IF EXISTS `t_view_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_view_story` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number_views` int DEFAULT NULL,
  `story_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9lsns8jw7tbviekrydh3kxwwf` (`story_id`),
  KEY `FKegea0igbgtsanoc2hsgxp90mx` (`user_id`),
  CONSTRAINT `FK9lsns8jw7tbviekrydh3kxwwf` FOREIGN KEY (`story_id`) REFERENCES `t_story` (`id`),
  CONSTRAINT `FKegea0igbgtsanoc2hsgxp90mx` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_view_story`
--

LOCK TABLES `t_view_story` WRITE;
/*!40000 ALTER TABLE `t_view_story` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_view_story` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24  5:16:43
