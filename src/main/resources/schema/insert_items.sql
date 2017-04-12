-- large_category
INSERT INTO `kakakucom`.`large_category` (`title`, `name`) VALUES ('パソコン', 'pc');
INSERT INTO `kakakucom`.`large_category` (`title`, `name`) VALUES ('家電', 'kaden');

-- small_category
INSERT INTO `kakakucom`.`small_category` (`large_category_id`, `title`, `name`) VALUES (1, 'ノートパソコン', 'note-pc');
INSERT INTO `kakakucom`.`small_category` (`large_category_id`, `title`, `name`) VALUES (2, '薄型テレビ', 'lcd-tv');

-- items
INSERT INTO `kakakucom`.`items` (`name`, `image_path`, `large_category_id`, `small_category_id`, `description`) VALUES ('HP 15-ba000 価格.com限定 フルHD非光沢&クアッドコア搭載モデル', '',  1, 1, '液晶サイズ：15.6インチ CPU：AMD Quad-Core E2-7110/1.8GHz/4コア CPUスコア：2255 ストレージ容量：HDD：500GB メモリ容量：4GB OS：Windows 10 Home 64bit');
INSERT INTO `kakakucom`.`items` (`name`, `image_path`, `large_category_id`, `small_category_id`, `description`) VALUES ('Lenovo YOGA 710 80V6000XJP', '',  1, 1, '液晶サイズ：11.6インチ CPU：Core i5 7Y54(Kaby Lake)/1.2GHz/2コア CPUスコア：3522 ストレージ容量：SSD：256GB メモリ容量：8GB OS：Windows 10 Home 64bit');

-- stores
INSERT INTO `kakakucom`.`stores` (`name`, `url`, `address`, `tel`, `bank_pay`, `credit_pay`, `convenience_pay`) VALUES ('レノボ・ショッピング', 'http://www3.lenovo.com/jp/ja/kakaku/deals/kakakumb/c/kakakumb', '東京都千代田区外神田4-14-1 秋葉原UDX', '0120-80-4545', 1, 1, 1);

-- store_item
INSERT INTO `kakakucom`.`store_item` (`store_id`, `item_id`, `price`, `stock`, `shipping_period`, `area`, `comment`, `color`, `url`, `is_deleted`) VALUES ('1', '1', '81907', '3', '3営業日', '東京', '■延長保証制度あり', 'ff0000', 'http://jp.ext.hp.com/notebooks/personal/hp_15_ba000/kakaku.html', 0);