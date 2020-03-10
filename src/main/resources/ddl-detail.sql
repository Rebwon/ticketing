drop table category if exists
drop table comment if exists
drop table comment_image if exists
drop table display if exists
drop table display_image if exists
drop table image if exists
drop table member if exists
drop table option if exists
drop table product if exists
drop table product_image if exists
drop table reservation if exists
drop table reservation_line_item if exists
drop table reservation_option if exists

create table category (
   id bigint generated by default as identity,
    name varchar(255),            -- 카테고리명
    primary key (id)
)

create table comment (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    comment clob,                 -- 사용자 한줄평
    product_id bigint,            -- 상품 ID
    reservation_id bigint,        -- 예매 ID
    score double,                 -- 평점
    primary key (id)
)

create table comment_image (
   display_id bigint,             -- 전시 ID
    reservation_id bigint,        -- 예매 ID
    id bigint not null,
    primary key (id)
)

create table display (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    place varchar(255),           -- 전시 장소
    place_lot varchar(255),       -- 전시 장소 지번 주소
    place_street varchar(255),    -- 전시 장소 도로명 주소
    email varchar(255) not null,  -- 전시 장소 이메일
    home_page varchar(255),       -- 전시자 홈페이지 주소
    opening_hours varchar(255),   -- 오프닝 시간 및 설명
    product_id bigint,            -- 상품 ID
    tel varchar(255),             -- 전시자 전화번호
    primary key (id)
)

create table display_image (
   image_type varchar(255),       -- 이미지 타입
    id bigint not null,
    primary key (id)
)

create table image (
   dtype varchar(31) not null,
    id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    content_type varchar(255),    -- MIME 타입
    deleted integer,              -- 삭제 여부 : 0(삭제안함) 1(삭제)
    img_name varchar(255),        -- 원본 이미지 이름
    save_img_name varchar(255),   -- 저장할 이미지 이름
    primary key (id)
)

create table member (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    email varchar(255) not null,
    primary key (id)
)

create table option (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    discount_rate double,        -- 할인율
    price bigint,                -- 가격
    product_type varchar(255),   -- 상품 타입
    product_id bigint,           -- 상품 ID
    primary key (id)
)

create table product (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    category_id bigint,          -- 카테고리 ID
    content clob,                -- 콘텐츠 설명
    description varchar(255),    -- 간략한 설명
    event varchar(255),          -- 이벤트 설명
    primary key (id)
)

create table product_image (
   image_type varchar(255),      -- 이미지 타입
    id bigint not null,
    primary key (id)
)

create table reservation (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    deleted integer,
    email varchar(255) not null, -- 예매자 이메일
    member_id bigint,            -- 예매자 ID / 비회원일 경우 NULL
    name varchar(255),           -- 예매자명
    reserve_date timestamp,      -- 예매날짜
    tel varchar(255),            -- 예매자 전화번호
    primary key (id)
)

create table reservation_line_item (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    count integer,               -- 예매 갯수
    product_id bigint,           -- 상품 ID
    reservation_id bigint,       -- 예매 ID
    primary key (id)
)

create table reservation_option (
   id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    name varchar(255),           -- 예매옵션 이름
    price bigint,                -- 예매 옵션 가격
    line_item_id bigint,         -- 예매항목 ID
    primary key (id)
)