USE `legohus`;

INSERT INTO `User`(`email`,`role`) VALUES
('bertha@testmail.com', 'customer'), 	#id 1
('hall@testmail.com', 'customer'), 		#id 2
('brandan@testmail.com', 'customer'), 	#id 3
('admin@testmail.com', 'employee'); 	#id 4

-- INSERT INTO `Component`() VALUES
-- ('2x1', 2),
-- ('2x2', 4),
-- ('2x4', 8);

-- INSERT INTO `Bill`(`bill_id`,`component_type`,`quantity`) VALUES
-- 					#height 4
-- (1, '2x4', 32), 	#x8
-- (1, '2x1', 16), 	#x4
-- 					#height 5
-- (2, '2x4', 25), 	#x5
-- (2, '2x2', 30), 	#x6
-- (2, '2x1', 20); 	#x4

-- INSERT INTO `Order`(`user_id`,`bill_id`,`order_send_date`) VALUES
-- (1, 1, '2019-02-22'),
-- (2, 2, '2019-02-20');

INSERT INTO `Order`(`user_id`, `length`, `width`, `height`, `order_receive_date`, `order_status`, `order_send_date`) VALUES
(1, 13, 9, 4, '2019-01-09', 'sent', '2019-01-12'),
(2, 12, 8, 5, '2019-02-25', 'sent', '2019-02-27'),
(1, 12, 8, 5, '2019-03-14', DEFAULT, NULL);