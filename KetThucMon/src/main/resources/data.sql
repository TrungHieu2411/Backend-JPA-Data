INSERT INTO customers (customer_name, customer_type, address, email, phone)
VALUES
  ('John Wick', 'VIP', 'Mỹ', 'johnwick@gmail.com', '0828984676'),
  ('Adam Smith', 'Thường', 'Anh', 'adamsmith@gmail.com', '0962888657'),
  ('Helen Keller', 'VIP', 'Nga', 'helenkeller@gmail.com', '0728894532'),
  ('Albert Einstein', 'Thường', 'Đức', 'alberteinstein@gmail.com', '0573899054'),
  ('Isaac Newton', 'VIP', 'Mỹ', 'isaacnewton@gmail.com', '0467803776'),
  ('Marie Curie', 'Thường', 'Pháp', 'mariecurie@gmail.com', '0782899764'),
  ('Charles Darwin', 'VIP', 'Anh', 'charlesdarwin@gmail.com', '0998764523'),
  ('Nikola Tesla', 'Thường', 'Nga', 'nikolatesla@gmail.com', '0965467765'),
  ('Leonardo da Vinci', 'VIP', 'Ý', 'leonardodavinci@gmail.com', '0987654321'),
  ('Galileo Galilei', 'Thường', 'Ý', 'galileogalilei@gmail.com', '0954687990');

INSERT INTO employees (employee_name, address, email, phone)
VALUES
  ('Nguyễn Văn Năm', 'Hà Nội', 'nguyenvannam@gmail.com', '0987654321'),
  ('Trần Thị Hai', 'Hà Nội', 'tranthihai@gmail.com', '0867888657'),
  ('Lê Văn Ba', 'TP.Hồ Chí Minh', 'levanba@gmail.com', '0953928999'),
  ('Phạm Thị Bốn', 'Đà Nẵng', 'phamthibon@gmail.com', '0989666512'),
  ('Hoàng Văn Chính', 'Nha Trang', 'hoangvanchinh@gmail.com', '0898965678'),
  ('Nguyễn Thị Sáu', 'Hải Phòng', 'nguyenthisau@gmail.com', '0678888903'),
  ('Trần Văn Hải', 'Cần Thơ', 'tranvanhai@gmail.com', '0568898453'),
  ('Lê Thị Tám', 'Cao Bằng', 'lethitam@gmail.com', '0898765909'),
  ('Phạm Thị Nhung', 'Bến Tre', 'phamthinhung@gmail.com', '0279483982'),
  ('Nguyễn Văn Mười', 'Đồng Tháp', 'nguyenvanmuoi@gmail.com', '0852796543');

INSERT INTO providers (provider_name, address, email, phone)
VALUES
  ('Thế Giới Di Động', 'Hà Nội', 'thegioididong@gmail.com', '0862789888'),
  ('FPT Shop', 'Hà Nội', 'fpt@gamil.com', '0739765457'),
  ('CellphoneS', 'TP.Hồ Chí Minh', 'cellphones@gmail.com', '0943276765'),
  ('Di Động Việt', 'Đà Nẵng', 'didongviet@gmail.com', '0845634451'),
  ('GearVN', 'TP.Hồ Chí Minh', 'gearvn@gmail.com', '0868909767'),
  ('Shop Dunk', 'Hà Nội', 'shopdunk@gmail.com', '0568908767'),
  ('Điện Máy Xanh', 'Hà Nội', 'dienmayxanh@gmail.com', '0978890541'),
  ('Hoàng Hà Mobile', 'Đà Nẵng', 'hoangha@gmail.com', '0656789098'),
  ('Viettel Store', 'Hà Nội', 'viettel@gmail.com', '0789676421'),
  ('XTMobile', 'TP.Hồ Chí Minh', 'xtmobile@gmail.com', '0627887561');

INSERT INTO producers (producer_name)
VALUES ('Apple'), ('Samsung'), ('Xiaomi'), ('Oppo'), ('Vivo'), ('Huawei'), ('Nokia'), ('Sony'), ('LG'), ('HTC');

INSERT INTO products(product_name, product_price, description, image, producer_id, provider_id)
VALUES
    ('Iphone 14 Pro Max', 30000000, 'Điện thoại Iphone 14 Pro Max', 'black-shark-5.png', 1, 1),
    ('Samsung Galaxy S21 Ultra', 25000000, 'Điện thoại Samsung Galaxy S21 Ultra', 'galaxynote-20Ultra.png', 2, 2),
    ('Xiaomi Mi 11', 20000000, 'Điện thoại Xiaomi Mi 11', 'galaxy-S23.png', 3, 3),
    ('Oppo Reno 6 Pro', 15000000, 'Điện thoại Oppo Reno 6 Pro', 'google-pixel-6.png', 4, 4),
    ('Vivo X60 Pro', 10000000, 'Điện thoại Vivo X60 Pro', 'iphone_14_purple.png', 5, 5),
    ('Huawei P50 Pro', 8000000, 'Điện thoại Huawei P50 Pro', 'iphone-13-pro-max.png', 6, 6),
    ('Nokia X20', 6000000, 'Điện thoại Nokia X20', 'iphone-14-pro-max.png', 7, 7),
    ('Sony Xperia 1 III', 4000000, 'Điện thoại Sony Xperia 1 III', 'Redmi-K60.png', 8, 8),
    ('LG Velvet', 2000000, 'Điện thoại LG Velvet', 'xiaomi-12s-ultra.png', 9, 9),
    ('HTC Desire 21 Pro 5G', 1000000, 'Điện thoại HTC Desire 21 Pro 5G', 'RogPhone-6Pro.png', 10, 10);

INSERT INTO orders (order_code, date_created, payment_method, order_status, customer_id, employee_id)
VALUES
    ('MHD001', '2023-06-01', 'Tiền mặt', 'Đã giao', 1, 1),
    ('MHD002', '2023-06-02', 'Chuyển khoản', 'Đang giao', 2, 2),
    ('MHD003', '2023-06-03', 'Tiền mặt', 'Đơn hàng mới', 3, 3),
    ('MHD004', '2023-06-04', 'Trả góp', 'Đơn hàng mới', 4, 4),
    ('MHD005', '2023-06-05', 'Tiền mặt', 'Đã huỷ', 5, 5),
    ('MHD006', '2023-06-06', 'Tiền mặt', 'Đang giao', 6, 6),
    ('MHD007', '2023-06-07', 'Tiền mặt', 'Đang giao', 7, 7),
    ('MHD008', '2023-06-08', 'Chuyển khoản', 'Đã giao', 8, 8),
    ('MHD009', '2023-06-09', 'Tiền mặt', 'Đang giao', 9, 9),
    ('MHD010', '2023-06-10', 'Trả góp', 'Đã huỷ', 10, 10);

INSERT INTO order_details (order_id, product_id, quantity, selling_price, total_price)
VALUES
    (1, 1, 2, 30000000, 60000000),
    (2, 2, 4, 25000000, 100000000),
    (3, 3, 2, 20000000, 40000000),
    (4, 4, 1, 15000000, 15000000),
    (5, 5, 2, 10000000, 20000000),
    (6, 6, 1, 8000000, 8000000),
    (7, 7, 1, 6000000, 6000000),
    (8, 8, 3, 4000000, 12000000),
    (9, 9, 1, 2000000, 2000000),
    (10, 10, 5, 1000000, 5000000);

INSERT INTO users (name, email, role, password)
VALUES
    ('Phạm Minh Huy', 'huy@gmail.com', 'ROLE_ADMIN', '$2a$10$7z.T/WmbKEyj6wt/SPadu.t5wkNmeI1qJigVAwU/WnFGXRUdBHyfW'),
    ('Trần Thị Thanh Thuỷ', 'thuy@gmail.com', 'ROLE_ADMIN', '$2a$10$7z.T/WmbKEyj6wt/SPadu.t5wkNmeI1qJigVAwU/WnFGXRUdBHyfW'),
    ('Thạch Lê Trung Hiếu', 'hieu@gmail.com', 'ROLE_ADMIN', '$2a$10$7z.T/WmbKEyj6wt/SPadu.t5wkNmeI1qJigVAwU/WnFGXRUdBHyfW');