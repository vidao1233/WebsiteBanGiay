USE [master]
GO
/****** Object:  Database [QuanLyBanGiay]    Script Date: 19/12/2022 8:16:09 PM ******/
CREATE DATABASE [QuanLyBanGiay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBanGiay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyBanGiay.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBanGiay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyBanGiay_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [QuanLyBanGiay] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBanGiay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBanGiay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBanGiay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBanGiay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyBanGiay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBanGiay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBanGiay] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBanGiay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBanGiay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBanGiay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBanGiay] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBanGiay] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QuanLyBanGiay]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [nchar](10) NULL,
	[pass] [nchar](10) NULL,
	[isSell] [bit] NULL,
	[isAdmin] [bit] NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cart]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[accountID] [int] NOT NULL,
	[productID] [int] NOT NULL,
	[amount] [int] NULL,
	[maCart] [int] IDENTITY(1,1) NOT NULL,
	[size] [nvarchar](50) NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[maCart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[maHD] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
	[tongGia] [float] NULL,
	[ngayXuat] [datetime] NULL,
 CONSTRAINT [PK_Invoice] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](200) NULL,
	[image] [nvarchar](500) NULL,
	[price] [float] NULL,
	[title] [nvarchar](500) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NOT NULL,
	[sell_ID] [int] NOT NULL,
	[model] [nvarchar](50) NULL,
	[color] [nvarchar](50) NULL,
	[delivery] [nvarchar](50) NULL,
	[image2] [nvarchar](500) NULL,
	[image3] [nvarchar](500) NULL,
	[image4] [nvarchar](500) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Review]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[accountID] [int] NULL,
	[productID] [int] NULL,
	[contentReview] [nvarchar](500) NULL,
	[dateReview] [date] NULL,
	[maReview] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[maReview] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SoLuongDaBan]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SoLuongDaBan](
	[productID] [int] NULL,
	[soLuongDaBan] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[idSupplier] [int] IDENTITY(1,1) NOT NULL,
	[nameSupplier] [nvarchar](100) NULL,
	[phoneSupplier] [nvarchar](50) NULL,
	[emailSupplier] [nvarchar](200) NULL,
	[addressSupplier] [nvarchar](200) NULL,
	[cateID] [int] NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[idSupplier] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TongChiTieuBanHang]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TongChiTieuBanHang](
	[userID] [int] NULL,
	[TongChiTieu] [float] NULL,
	[TongBanHang] [float] NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (1, N'admin     ', N'1233      ', 0, 1, N'dutran2392002@gmail.com')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (2, N'dutran    ', N'1233      ', 1, 0, N'20110618@student.hcmute.edu.vn')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (3, N'nanguyen  ', N'1233      ', 1, 0, N'20110678@student.hcmute.edu.vn')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (4, N'vidao     ', N'1233      ', 0, 0, N'20110223@student.hcmute.edu.vn')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (5, N'anguyen   ', N'123       ', 0, 0, N'nguyenvana@gmail.com')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (6, N'btran     ', N'123       ', 0, 0, N'tranthib@gmail.com')
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin], [email]) VALUES (7, N'cle       ', N'123       ', 0, 0, N'lethic@gmail.com')
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[Cart] ON 

INSERT [dbo].[Cart] ([accountID], [productID], [amount], [maCart], [size]) VALUES (4, 22, 1, 1, N'medium')
INSERT [dbo].[Cart] ([accountID], [productID], [amount], [maCart], [size]) VALUES (4, 15, 2, 2, N'large')
INSERT [dbo].[Cart] ([accountID], [productID], [amount], [maCart], [size]) VALUES (5, 15, 3, 3, N'small')
INSERT [dbo].[Cart] ([accountID], [productID], [amount], [maCart], [size]) VALUES (5, 35, 1, 4, N'small')
SET IDENTITY_INSERT [dbo].[Cart] OFF
INSERT [dbo].[Category] ([cid], [cname]) VALUES (1, N'GIAY ADIDAS')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (2, N'GIAY NIKE')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (3, N'GIAY BITIS')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (4, N'GIAY CONVERSE')
SET IDENTITY_INSERT [dbo].[Invoice] ON 

INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (1, 1, 999, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (2, 1, 800, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (3, 1, 400, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (4, 1, 511.2, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (5, 1, 241.2, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (6, 1, 392.4, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (7, 1, 482.4, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (8, 2, 300, CAST(N'2021-11-18 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (9, 2, 400, CAST(N'2021-11-17 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (10, 1, 180, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (11, 1, 1079.1, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (12, 1, 122.4, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (13, 1, 1394.1, CAST(N'2021-11-20 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (14, 2, 256, CAST(N'2021-10-01 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (15, 3, 450, CAST(N'2021-10-03 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (16, 2, 200, CAST(N'2021-09-05 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (17, 2, 100, CAST(N'2021-08-06 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (18, 3, 156, CAST(N'2021-07-07 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (19, 3, 256, CAST(N'2021-06-06 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (20, 3, 158, CAST(N'2021-05-05 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (21, 2, 800, CAST(N'2021-04-04 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (22, 3, 750, CAST(N'2021-03-03 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (23, 2, 657, CAST(N'2021-02-02 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (24, 1, 800, CAST(N'2021-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (25, 1, 1491.6, CAST(N'2021-11-25 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (26, 1, 396, CAST(N'2021-11-26 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (27, 1, 761.2, CAST(N'2021-11-29 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (28, 1, 1687.4, CAST(N'2021-11-29 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (29, 1, 1760, CAST(N'2021-11-29 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (30, 1, 2175.8, CAST(N'2021-12-01 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (31, 1, 396, CAST(N'2021-12-01 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (32, 1, 739.2, CAST(N'2021-12-02 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (33, 1, 567.6, CAST(N'2021-12-03 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (34, 1, 803, CAST(N'2021-12-14 00:00:00.000' AS DateTime))
INSERT [dbo].[Invoice] ([maHD], [accountID], [tongGia], [ngayXuat]) VALUES (35, 2, 171.6, CAST(N'2022-12-19 00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Invoice] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (11, N'GIÀY NIKE AIR MAX AP NAM - XÁM XANH _ Baocao', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_A_PREM-550x550.jpg', 180, N'GIÀY NIKE AIR MAX AP NAM - XÁM XANH', N'Giày Nike Air Max AP là mẫu giày với thiết kế vô cùng thời trang của Nike với sự kết hợp hài hòa giữa quá khứ và hiện đại.

Phần đế giữa của Nike Air Max AP được thiết kế rất hợp lý mềm mại với công nghệ tiên tiến nhất của Nike. Chắc chắn đây là mẫu giày mà bất cứ fan Sneaker không thể bỏ qua', 2, 2, N'G87', N'Gray', N'Hải Phòng', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_C_PREM-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_D_PREM-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_F_PREM-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (15, N'Adidas Ultraboost 4.0 -2', N'https://product.hstatic.net/1000282067/product/giay_ultraboost_mau_xanh_da_troi_g54002_e902370c1de04294ad2602df86bc7c7c_1024x1024.jpg', 156, N'Adidas Ultraboost 4.0', N'KIỂM SOÁT LỰC KHI CHẠM ĐẤT, THOẢI MÁI TRONG TỪNG BƯỚC CHẠY.

Giày Sneaker Nam Nữ Adidas Ultraboost 4.0 FU9993 – Hàng Chính Hãng

', 1, 2, N'G87', N'Blue', N'Long An', N'https://images.solecollector.com/complex/images/fl_lossy,q_auto/c_scale,w_690,dpr_2.0/v1/dq2zuhqxoufskbl1ycjd/adidas-ultra-boost-4-navy', N'https://product.hstatic.net/1000282067/product/529360_01.jpg_37102ca9b517400d8159d0dd501ac79e_1024x1024.jpeg', N'https://product.hstatic.net/1000282067/product/ultraboost_shoes_blue_g54002_05_standard_bc063c8c6fa5466f868a6765dd896386_1024x1024.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (19, N'Giày Nike Air Max SC Nam- Đen Trắng', N'https://myshoes.vn/image/cache/catalog/nike/24.10/giay-nike-air-max-sc-nam-den-trang-01-550x550.jpg', 190, N'Giày Nike Air Max SC Nam- Đen Trắng', N'mang nét huyền thoại của Nike, với bộ đệm Air Max trứ danh đây là mẫu giày có thể kết hợp với bất cứ trang phục nào mà bạn vẫn hoàn toàn tự tin trong mọi hoàn cảnh.', 2, 2, N'G68', N'Black', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/24.10/giay-nike-air-max-sc-nam-den-trang-06-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/24.10/giay-nike-air-max-sc-nam-den-trang-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/24.10/giay-nike-air-max-sc-nam-den-trang-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (20, N'Giày Nike Court Royale 2 Nam - Đen', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-den-01-550x550.jpg', 490, N'Giày Nike Court Royale 2 Nam - Đen', N'Giày Nike Court Royale 2 NN là mẫu giày với thiết kế lấy cảm hứng từ thập niên 70 với những nét cổ điển mang phong cách đường phố đặc trưng. Ngoài ra, Nike Court Royale 2 NN làm từ vật liệu thân thiện với môi trường.', 2, 2, N'G68', N'Black', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-den-06-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-den-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-den-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (21, N'Giày Nike Air Max AP Nam - Đen', N'https://myshoes.vn/image/cache/catalog/nike/22.10/giay-Nike-Air-Max-AP-nam-den-01-550x550.jpg', 690, N'Giày Nike Air Max AP Nam - Đen', N'Giày Nike Air Max AP là mẫu giày với thiết kế vô cùng thời trang của Nike với sự kết hợp hài hòa giữa quá khứ và hiện đại.

Phần đế giữa của Nike Air Max AP được thiết kế rất hợp lý mềm mại với công nghệ tiên tiến nhất của Nike. Chắc chắn đây là mẫu giày mà bất cứ fan Sneaker không thể bỏ qua', 2, 2, N'G68', N'Black', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/22.10/giay-Nike-Air-Max-AP-nam-den-06-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/giay-Nike-Air-Max-AP-nam-den-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/giay-Nike-Air-Max-AP-nam-den-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (22, N'Giày Nike Renew Retaliation TR 3 Nam - Đen Trắng ', N'https://myshoes.vn/image/cache/catalog/nike1/giay-Nike-Renew-Retaliation-TR-3-01-550x550.jpg', 890, N'Giày Nike Renew Retaliation TR 3 Nam - Đen Trắng', N'Giày Nike Renew Retaliation TR 3 một mẫu giày training không thể bỏ qua, với thiết kế phù hợp nhất cho việc luyện tập thể thao, tập gym...

Phần đế giày với công nghệ React cực kỳ êm và nhẹ giúp cho các vận động linh hoạt và nhẹ nhàng hơn rất nhiều. Phần upper với sợi dệt vô cùng thoáng khí và cấu trúc dây buộc chắc chắn cố định giúp giảm tối đa các chấn thương trong quá trình luyện tập.

', 2, 2, N'G68', N'Black', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike1/giay-Nike-Renew-Retaliation-TR-3-03-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/giay-Nike-Renew-Retaliation-TR-3-02-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/giay-Nike-Renew-Retaliation-TR-3-05-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (24, N'Giày Nike Air Zoom Structure 24 Nam - Trắng', N'https://myshoes.vn/image/cache/catalog/nike/10.11/giay-nike-air-zoom-structure-24-nam-trang-01-550x550.jpg', 390, N'Giày Nike Air Zoom Structure 24 Nam - Trắng', N'Ở phiên bản này được các chuyên gia đánh giá cao phần bởi sự ổn định nhưng vẫn có cảm giác êm chân trong suốt quá trình sử dụng. Bạn yêu thích thể thao và đang tìm kiếm cho mình một đôi giày để tập luyện thì Nike Air Zoom Structure 24 sẽ là một lựa chọn hoàn toàn chính xác. Bởi một đôi giày tốt sẽ là một người đồng hành quan trọng trong cả 1 quá trình.', 2, 2, N'G68', N'White', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/10.11/giay-nike-air-zoom-structure-24-nam-trang-02-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/10.11/giay-nike-air-zoom-structure-24-nam-trang-03-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/10.11/giay-nike-air-zoom-structure-24-nam-trang-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (25, N'Giày Nike Court Royale 2 Nam Nữ - Trắng', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-trang-01-550x550.jpg', 490, N'Giày Nike Court Royale 2 Nam Nữ - Trắng', N'Mua Hàng Ngay', 2, 2, N'G68', N'White', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-trang-06-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-trang-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/22.10/Nike-Court-Royale-2-Nam-trang-02-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (26, N'Giày Nike Revolution 5 Nữ - Trắng Full', N'https://myshoes.vn/image/cache/data/nike%202019/nike/nike%202021/giay-nike-revolution-5-nu-trang-full-01-550x550.jpg', 590, N'Giày Nike Revolution 5 Nữ - Trắng Full', N'Mẫu giày Nike Revolution 5 sẽ là lựa chọn hoàn hảo, hợp lý,chính xác cho bạn. Với công nghệ được thiết kế để vừa chạy vừa có thể tập được thể thao nhưng lại không quá đắt như Zoom hay React. Nike Revolution 5 sẽ là mẫu giày mà các tín đồ yêu thích thể thao nên có cho mình một đôi. Đồng thời với lối thiết kế trẻ trung, hiện đại thì bạn có thể dùng chính đôi giày này để kết hợp với các Outfit thường ngày.', 2, 2, N'G68', N'White', N'Long An', N'https://myshoes.vn/image/cache/data/nike%202019/nike/nike%202021/giay-nike-revolution-5-nu-trang-full-06-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/nike/nike%202021/giay-nike-revolution-5-nu-trang-full-02-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/nike/nike%202021/giay-nike-revolution-5-nu-trang-full-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (27, N'Giày Nike Air Max Zero Essential Nam Trắng Full', N'https://myshoes.vn/image/cache/data/nike%202019/3.5.19/giay-nike-air-max-zero-essential-nam-trang-full-01-550x550.jpg', 690, N'Giày Nike Air Max Zero Essential Nam Trắng Full', N'Một trong những mẫu giày Casual giúp bạn dễ dàng kết hợp cùng các kiểu dáng quần áo khác nhau. Đây sẽ là đôi giày sẽ khiến bạn không phải đau đầu trong việc lựa chọn giày đi vào dịp gì-từ đi chơi cho đến đi làm. Thiết kế trẻ trung, khỏe khoắn giúp bạn tự tin trên mọi cung đường.', 2, 2, N'G68', N'White', N'Long An', N'https://myshoes.vn/image/cache/data/nike%202019/3.5.19/giay-nike-air-max-zero-essential-nam-trang-full-03-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/3.5.19/giay-nike-air-max-zero-essential-nam-trang-full-05-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/3.5.19/giay-nike-air-max-zero-essential-nam-trang-full-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (28, N'GIÀY ADIDAS HOOPS 2.0 NAM - TRẮNG', N'https://myshoes.vn/image/cache/catalog/2022/adidas2/28.10/giay-adidas-hoops-2-nam-trang-01-550x550.jpg', 890, N'GIÀY ADIDAS HOOPS 2.0 NAM - TRẮNG', N'Giày adidas Hoops 2.0 phiên bản nâng cấp rất được ưu chuộng của dòng adidas Hoops . Adidas Hoop 2.0 với phần upper được kết hợp hoàn hảo từ các chất liệu vải, da lộn, da trơn cao cấp giúp đôi giày thật sự đẹp và thời trang.

Giày adidas Hoops 2.0 chắc chắn sẽ là một mẫu giày không thể nào bỏ qua được trong năm nay.', 1, 2, N'G68', N'White', N'Long An', N'https://myshoes.vn/image/cache/catalog/2022/adidas2/28.10/giay-adidas-hoops-2-nam-trang-03-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas2/28.10/giay-adidas-hoops-2-nam-trang-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas2/28.10/giay-adidas-hoops-2-nam-trang-06-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (29, N'Giày Bóng Đá Nam Hunter Football DSMH11100XNH (Xanh Nhớt)', N'https://product.hstatic.net/1000230642/product/dsmh11100xnh__4__97d865249a4e4a349c054c7cf85ffef1.jpg', 590, N'Giày Bóng Đá Nam Hunter Football DSMH11100XNH (Xanh Nhớt)', N'Giày Bóng Đá Nam Biti''s Hunter Football được ứng dụng với nền tảng công nghệ TrueFit – X, sản phẩm giày đá banh từ Biti’s Hunter với cam kết đem lại trải nghiệm vừa vặn nhất với đôi chân. 
- Quai da tổng hợp cao cấp chuyên dụng cho giày đá banh với độ dày 1.3mm nhưng vẫn đảm bảo được độ mềm, uốn gấp tạo cảm giác thoải mái và độ bền có khả năng chịu lực cao. 

- Rãnh ma sát trên bề mặt giày tang “cảm giác bóng” và tang độ ổn dịnh khi tiếp xúc bóng. ', 3, 2, N'G68', N'Blue', N'Long An', N'https://product.hstatic.net/1000230642/product/dsmh11100xnh__10__90462d9d79ff40a293c4b7d089769a37.jpg', N'https://product.hstatic.net/1000230642/product/dsmh11100xnh__7__1248f5fa762a433aab60c8e8b9a9dfde.jpg', N'https://product.hstatic.net/1000230642/product/dsmh11100xnh__9__9714d17daf4040eeb3b3f19d639757f6.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (30, N'Giày Thể Thao Nam Hunter X Xám', N'https://product.hstatic.net/1000230642/product/dsmh10500xam__2__4d84d50f5d9741f6b6d74dcd716f4176.jpg', 590, N'Giày Thể Thao Nam Hunter X Xám', N'- Điểm nhấn nổi bật : Quai knits thông thoáng. Đế IP/Cao su nhẹ, uốn gấp đàn hồi tốt. 

- Ý tưởng thiết kế: từ những góc cắt mạnh mẽ liên kết từ thành đế tạo sự đồng nhất sản phẩm', 3, 3, N'G68', N'Gray', N'Long An', N'https://product.hstatic.net/1000230642/product/dsmh10500xam__5__113fd43149a74ead82897abb58b78cf9.jpg', N'https://product.hstatic.net/1000230642/product/dsmh10500xam__4__7918383faa5840749c4d1fd6a7bede3a.jpg', N'https://product.hstatic.net/1000230642/product/dsmh10500xam__6__5d70fee9e27a44c2aa845c298cb7fd8d.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (31, N'Giày Nike Air Zoom Structure 23 Nam - Xám', N'https://myshoes.vn/image/cache/catalog/nike/25.10/giay-nike-structure-23-nam-xam-01-550x550.jpg', 90, N'Giày Nike Air Zoom Structure 23 Nam - Xám', N'Giày Nike Air Zoom Structure 23 là mẫu giày được nâng cấp rất nhiều so với phiên bản trước đó: nhẹ hơn, khỏe khoắn hơn, mang lại trải nghiệm tuyệt vời cho người dùng.

Ở phiên bản này được các chuyên gia đánh giá cao phần bởi sự ổn định nhưng vẫn có cảm giác êm chân trong suốt quá trình sử dụng.', 2, 3, N'G68', N'Gray', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike/25.10/giay-nike-structure-23-nam-xam-06-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/25.10/giay-nike-structure-23-nam-xam-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike/25.10/giay-nike-structure-23-nam-xam-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (32, N'Giày Nike Air Max AP Nam - Xám Xanh', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_A_PREM-550x550.jpg', 690, N'Giày Nike Air Max AP Nam - Xám Xanh', N'Giày Nike Air Max AP là mẫu giày với thiết kế vô cùng thời trang của Nike với sự kết hợp hài hòa giữa quá khứ và hiện đại.

Phần đế giữa của Nike Air Max AP được thiết kế rất hợp lý mềm mại với công nghệ tiên tiến nhất của Nike. Chắc chắn đây là mẫu giày mà bất cứ fan Sneaker không thể bỏ qua', 2, 3, N'G68', N'Gray', N'Long An', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_C_PREM-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_D_PREM-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/nike1/NIKE-CU4826_003_E_PREM-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (33, N'Giày adidas Edge Lux Nữ - Xám', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-edge-lux-nu-xam-01-550x550.jpg', 90, N'Giày adidas Edge Lux Nữ - Xám', N'* Myshoes.vn cam kết:', 1, 3, N'G68', N'Gray', N'Long An', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-edge-lux-nu-xam-06-550x550.jpg', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-edge-lux-nu-xam-05-550x550.jpg', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-edge-lux-nu-xam-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (34, N'Giày adidas Super Nova Nữ Xám', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-super-nova-nu-xam-01-550x550.jpg', 390, N'Giày adidas Super Nova Nữ Xám', N'Adidas Supernova này có đế giữa hybrid kết hợp công nghệ Boost và Bounce cho cảm giác êm ái và thoải mái. Đây là một đôi giày tập luyện và huấn luyện ở mức độ trung bình hàng ngày.

Adidas Supernova là giày running, ngoài ra nó có thể sử dụng đi bộ, mặc phối đồ với những trang phục hàng ngày thoải mái và phong cách.', 1, 3, N'G68', N'Gray', N'Long An', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-super-nova-nu-xam-02-550x550.jpg', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-super-nova-nu-xam-03-550x550.jpg', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-super-nova-nu-xam-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (35, N'Giày Nike Epic React Flyknit 2 Nam - Xám Xanh', N'https://myshoes.vn/image/cache/data/nike%202019/7.6.19/giay-nike-epic-react-2%20flyknit-nam-xam-xanh-01-550x550.jpg', 790, N'Giày Nike Epic React Flyknit 2 Nam - Xám Xanh', N'* Myshoes.vn cam kết:', 2, 3, N'G68', N'Gray', N'Long An', N'https://myshoes.vn/image/cache/data/nike%202019/7.6.19/giay-nike-epic-react-2%20flyknit-nam-xam-xanh-06-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/7.6.19/giay-nike-epic-react-2%20flyknit-nam-xam-xanh-05-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/7.6.19/giay-nike-epic-react-2%20flyknit-nam-xam-xanh-04-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (36, N'Giày Nike Air Zoom Pegasus 37 Nam - Đen Vàng', N'https://myshoes.vn/image/cache/data/nike%202019/nike/giay-nike-air-zoom-pegasus-37-nam-den-vang-01-550x550.jpg', 790, N'Giày Nike Air Zoom Pegasus 37 Nam - Đen Vàng', N'Tiếp theo, phần Upper đã được cải tiến, thay thế bằng một lớp Mesh khác hoàn toàn trước kia. Lớp lưới này nhẹ hơn, dày hơn nhưng tuyệt đối vẫn giữ được sự thông thoáng, thoải mái trong từng mọi hoạt động của bàn chân. Lưỡi gà, cũng được Cut Out tinh tế để fit vừa vặn với các kiểu cổ chân khác nhau đồng thời tăng khả năng điều chỉnh đến một cách linh hoạt nhất.', 2, 3, N'G68', N'Black', N'Long An', N'https://myshoes.vn/image/cache/data/nike%202019/nike/giay-nike-air-zoom-pegasus-37-nam-den-vang-04-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/nike/giay-nike-air-zoom-pegasus-37-nam-den-vang-06-550x550.jpg', N'https://myshoes.vn/image/cache/data/nike%202019/nike/giay-nike-air-zoom-pegasus-37-nam-den-vang-05-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (37, N'Converse Jack Purcell LP L/S - 570483C', N'https://drake.vn/image/cache/catalog/Hinh%20add%20dut%20size/05.05.2022/CONVERSE/51%20TOI%20120/570483C_P108-650x650.jpg', 490, N'Converse Jack Purcell LP L/S - 570483C', N'Quay trở lại vào một dịp không ngờ đến, Converse trình làng thiết kế Jack Purcell ưu ái dành cho nữ. Với phiên bản Canvas có phần đế được làm mỏng, nhẹ hơn, mẫu giày Converse Jack Purcell LP L/S mang đến sự thoải mái, tiện nghi để các nàng tha hồ tung tăng dạo phố. Gam màu basic chứa sức hút không tưởng, sẽ là mảnh ghép vừa vặn cho bộ trang phục của nàng thêm tinh tế.', 4, 3, N'G68', N'Black', N'Long An', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/570483C/570483-1-650x650.jpg', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/570483C/570483-3-650x650.jpg', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/570483C/570483-2-650x650.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (38, N'Giày Bóng Đá Nam Bitis Hunter Football', N'https://product.hstatic.net/1000230642/product/02400vag__1__5d559f914caf4864ad99a37c18cc1a1b_1024x1024.jpg', 535, N'Giày Bóng Đá Nam Biti Hunter Football', N'Với thiết kế năng động, Giày bóng đá Biti’s Hunter được tung ra với 5 màu sắc nổi bật tạo điểm nhấn trên sân đấu.', 3, 3, N'G39', N'Yellow', N'Ho Chi Minh', N'https://product.hstatic.net/1000230642/product/02400vag__3__3a83e45335054285a27fba37cafb23c1_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/02400vag__4__d3693ef3babe4fc3a2908d8eb2df6e3b_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/02400vag__4__d3693ef3babe4fc3a2908d8eb2df6e3b_1024x1024.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (39, N'Converse Star Replay Lost in Cons ', N'https://drake.vn/image/cache/catalog/Hinh%20add%20dut%20size/05.05.2022/CONVERSE/51%20TOI%20120/165652_P113-500x500.jpg', 399, N'Converse Star Replay Lost in Cons ', N'Converse Star Replay Lost in Cons phá cách, ấn tượng với thiết kế form dáng nam tính, mạnh mẽ. Đồng thời chi tiết logo hình ngôi sao năm cánh nổi bật biểu tượng của dòng Cons One Star trên nền Suede cao cấp cộng thêm phần đế giày được làm từ chất liệu cao su siêu bền dành cho những ai phải thường xuyên vận động', 4, 3, N'G89', N'Gray', N'Hà Nội', N'https://drake.vn/image/cache/catalog/Converse/Cons/165652C/165652C-DRAKE1-150x150.jpg', N'https://drake.vn/image/cache/catalog/Converse/Cons/165652C/165652C-DRAKE2-150x150.jpg', N'https://drake.vn/image/cache/catalog/H%C3%ACnh%20content/converse-star-replay-lost-in-cons/converse-star-replay-lost-in-cons-02-410x574.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (40, N'GIÀY ADIDAS GALAXY 6 NỮ - TRẮNG XANH', N'https://myshoes.vn/image/cache/catalog/2022/adidas/13.9/giay-adidas-galaxy-6-nu-trang-xanh-02-550x550.jpg', 140, N'GIÀY ADIDAS GALAXY 6 NỮ - TRẮNG XANH', N'Giày adidas Galaxy 6  có thiết kế thể thao đẹp mắt, đây là mẫu giày có thể sử dụng trong mọi hoạt động hàng ngày. adidas Galaxy 6 có nhiều cải tiến so với adidas Galaxy 5 giúp đôi giày ngày càng hoàn hảo.', 1, 3, N'G76', N'White', N'Nha Trang', N'https://myshoes.vn/image/cache/catalog/2022/adidas/13.9/giay-adidas-galaxy-6-nu-trang-xanh-02-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas/13.9/giay-adidas-galaxy-6-nu-trang-xanh-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas/13.9/giay-adidas-galaxy-6-nu-trang-xanh-06-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (41, N'GIÀY ADIDAS SUPER COURT NỮ TRẮNG FULL', N'https://myshoes.vn/image/cache/data/adidas%202019/22.3.19/giay-adidas-super-court-nu-trang-full-01-550x550.jpg', 189, N'GIÀY ADIDAS SUPER COURT NỮ TRẮNG FULL', N'Bạn đang tìm kiếm cho mình một đôi giày sẽ có thể trường tồn với thời gian, không bị lỗi mốt theo năm tháng. Adidas Super Court là 1 lựa chọn không nên bỏ lỡ . Kiểu dáng thiết kế trẻ trung, màu sắc tươi sắc nên Adidas Super Court sẽ là kiểu giày giúp bạn dễ dàng chuyển từ ''bánh bèo" sang '' cá tính'' trong một nốt nhạc.', 1, 3, N'G89', N'White', N'Nha Trang', N'https://myshoes.vn/image/cache/data/giay-adidas-super-court-nu-trang-full-05-550x550.jpg', N'https://myshoes.vn/image/cache/data/giay-adidas-super-court-nu-trang-full-03-550x550.jpg', N'https://myshoes.vn/image/cache/data/giay-adidas-super-court-nu-trang-full-02-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (42, N'Chuck Taylor All Star Classic', N'https://drake.vn/image/cache/catalog/Converse/Classic/Hi%CC%80nh%20chu%CC%89/121178-DRAKE-500x500.jpg', 225, N'Chuck Taylor All Star Classic', N'Phiên bản màu đen của Converse Classic cổ thấp chắc chắn là item đơn giản phù hợp với mọi phong cách đáng để bạn sở hữu. Với thiết kế cổ điển được ưa chuộng của dòng Classic đi kèm với chất liệu vải Canvas mềm nhẹ, phần để cao su bền chắc cùng đường viền đen đặc trưng, tin chắc đây sẽ là item giúp cho các set đồ của bạn trở nên đầy phong cách.', 4, 3, N'G76', N'Black', N'Nha Trang', N'https://drake.vn/image/cache/catalog/Converse/Classic/121178/121178-DRAKE2-1-150x150.jpg', N'https://drake.vn/image/cache/catalog/Converse/Classic/121178/121178-DRAKE1-150x150.jpg', N'https://myshoes.vn/image/cache/data/giay-adidas-super-court-nu-trang-full-02-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (43, N'GIÀY ADIDAS SUPERNOVA 2 NAM - XÁM
', N'https://myshoes.vn/image/cache/catalog/2022/adidas/17.10.2/giay-adidas-supernova-2-nam-xam-01-550x550.jpg', 225, N'GIÀY ADIDAS SUPERNOVA 2 NAM - XÁM
', N'Giày adidas Supernova 2 có phần upper được làm từ chất liệu mesh thoáng khí, phần đế giữa kết hợp 2 công nghệ Bounce và Boost trứ danh mang đến cho người sử dụng cảm giác êm ái dễ chịu khó tìm thấy ở sản phẩm thông thường. Bạn có thể sử dụng đôi giày này để đi cả ngày hoặc chạy bộ quãng đường rất dài mà không cảm thấy đau chân hay khó chịu gì cả.', 4, 3, N'G89', N'Gray', N'Nha Trang', N'https://myshoes.vn/image/cache/catalog/2022/adidas/17.10.2/giay-adidas-supernova-2-nam-xam-02-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas/17.10.2/giay-adidas-supernova-2-nam-xam-05-550x550.jpg', N'https://myshoes.vn/image/cache/catalog/2022/adidas/17.10.2/giay-adidas-supernova-2-nam-xam-06-550x550.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (44, N'Converse Chuck Taylor All Star Renew Sock Knit', N'https://drake.vn/image/cache/catalog/Hinh%20add%20dut%20size/05.05.2022/CONVERSE/51%20TOI%20120/170367C_P101-650x650.jpg', 198, N'Converse Chuck Taylor All Star Renew Sock Knit', N'Converse Chuck Taylor All Star Crate Knit đã trở lại để mang sự cổ điển đến gần hơn với một tương lai không lãng phí. Kiểu dáng Chuck Taylor với phần đế cao su được làm từ Công nghệ Nike Grind kết hợp với xốp Nike và cao su tái chế. Ngoài ra, upper được làm từ chất vải Polyester với công nghệ dệt kỹ thuật tiên tiến, sợi vải được dệt từ 75% poly tái chế và 25% nilon spandex (loại sợi nhân tạo có khả năng co giãn 4 chiều). ', 4, 3, N'G87', N'Gray', N'Nha Trang', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/170367C/170367C-8-410x574.jpg', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/170367C/170367C-3-410x574.jpg', N'https://drake.vn/image/cache/catalog/Converse/GIA%CC%80Y%202/170367C/170367C-2-410x574.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (45, N'Hunter Layered Upper', N'https://product.hstatic.net/1000230642/product/dsc_0024_a6274cb2948449c785a7269de5fa6349_1024x1024.jpg', 800, N'Hunter Layered Upper', N'Sản phẩm rất tốt đi thoải mái', 3, 3, N'G68', N'White', N'Nha Trang', N'https://product.hstatic.net/1000230642/product/dsc_0025_703ee09f5db24cd9a0c8604cdd2592aa_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/dsc_0026_60087f45b9394f0682f5126309f5d3f6_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/dsc_0027_647fb72ecf3d455590cddb79c2418458_1024x1024.jpg')
INSERT [dbo].[Product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [model], [color], [delivery], [image2], [image3], [image4]) VALUES (46, N'Hunter Layered Upper', N'https://product.hstatic.net/1000230642/product/02800den__2__f00d5533d44b47ac84212239f93ebac6_1024x1024.jpg', 767, N'Hunter Layered Upper', N'Sản phẩm rất tốt đi rất thoải mái', 3, 3, N'G45', N'Black', N'Nha Trang', N'https://product.hstatic.net/1000230642/product/02800den__3__0f4c2b667bb44347ac302726b71ce9a2_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/02800den__4__ef90bd83d09942fd87d72165e5ce2fc7_1024x1024.jpg', N'https://product.hstatic.net/1000230642/product/02800den__5__fb6f5367106342348f60cd7b9b70dee6_1024x1024.jpg')
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[Review] ON 

INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 15, N'xin chao san pham nay rat tot', CAST(N'2021-11-19' AS Date), 2)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'xin chào', CAST(N'2021-11-24' AS Date), 14)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'sản phẩm này rất tốt', CAST(N'2021-11-25' AS Date), 15)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'xin chao 2', CAST(N'2021-11-26' AS Date), 16)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'fsdf', CAST(N'2021-12-01' AS Date), 17)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'xin chao 3', CAST(N'2021-12-02' AS Date), 18)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'xin chao 4', CAST(N'2021-12-03' AS Date), 19)
INSERT [dbo].[Review] ([accountID], [productID], [contentReview], [dateReview], [maReview]) VALUES (1, 11, N'bao cao', CAST(N'2021-12-14' AS Date), 20)
SET IDENTITY_INSERT [dbo].[Review] OFF
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (11, 23)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (15, 14)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (19, 21)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (20, 9)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (21, 7)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (24, 10)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (46, 2)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (45, 4)
INSERT [dbo].[SoLuongDaBan] ([productID], [soLuongDaBan]) VALUES (41, 2)
SET IDENTITY_INSERT [dbo].[Supplier] ON 

INSERT [dbo].[Supplier] ([idSupplier], [nameSupplier], [phoneSupplier], [emailSupplier], [addressSupplier], [cateID]) VALUES (1, N'Cty TNHH D.ADDIDAS', N'091121786', N'cty@gmail.com', N'so 1 Vo Van Ngan', 1)
INSERT [dbo].[Supplier] ([idSupplier], [nameSupplier], [phoneSupplier], [emailSupplier], [addressSupplier], [cateID]) VALUES (2, N'Cty TNHH D.NIKE', N'091121786', N'cty@gmail.com', N'so 2 Vo Van Ngan', 2)
INSERT [dbo].[Supplier] ([idSupplier], [nameSupplier], [phoneSupplier], [emailSupplier], [addressSupplier], [cateID]) VALUES (3, N'Cty TNHH D.BITIS', N'091121786', N'cty@gmail.com', N'so 3 Vo Van Ngan', 3)
INSERT [dbo].[Supplier] ([idSupplier], [nameSupplier], [phoneSupplier], [emailSupplier], [addressSupplier], [cateID]) VALUES (4, N'Cty TNHH D.CONVERSE', N'091121786', N'cty@gmail.com', N'so 4 Vo Van Ngan', 4)
SET IDENTITY_INSERT [dbo].[Supplier] OFF
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (1, 1340, 14238)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (2, 600, 4000)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (3, 450, 3500)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (4, 900, 3000)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (5, 800, 2500)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (6, 660, 2700)
INSERT [dbo].[TongChiTieuBanHang] ([userID], [TongChiTieu], [TongBanHang]) VALUES (7, 271.6, 150)
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Account]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Product]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Account]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Account] FOREIGN KEY([sell_ID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Account]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Account]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Product]
GO
ALTER TABLE [dbo].[SoLuongDaBan]  WITH CHECK ADD  CONSTRAINT [FK_SoLuongDaBan_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[SoLuongDaBan] CHECK CONSTRAINT [FK_SoLuongDaBan_Product]
GO
ALTER TABLE [dbo].[Supplier]  WITH CHECK ADD  CONSTRAINT [FK_Supplier_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[Supplier] CHECK CONSTRAINT [FK_Supplier_Category]
GO
ALTER TABLE [dbo].[TongChiTieuBanHang]  WITH CHECK ADD  CONSTRAINT [FK_TongChiTieuBanHang_Account] FOREIGN KEY([userID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[TongChiTieuBanHang] CHECK CONSTRAINT [FK_TongChiTieuBanHang_Account]
GO
/****** Object:  StoredProcedure [dbo].[proc_CapNhatSoLuongDaBan]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_CapNhatSoLuongDaBan] @productID int, @soLuongBanThem int
as
begin
	update SoLuongDaBan set [soLuongDaBan]=[soLuongDaBan] + @soLuongBanThem where productID=@productID
end


GO
/****** Object:  StoredProcedure [dbo].[proc_CapNhatTongBanHang]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_CapNhatTongBanHang] @sell_ID int, @banHangThem float
as
begin
	update TongChiTieuBanHang set TongBanHang= TongBanHang + @banHangThem where [userID]=@sell_ID
end


GO
/****** Object:  StoredProcedure [dbo].[proc_CapNhatTongChiTieu]    Script Date: 19/12/2022 8:16:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_CapNhatTongChiTieu] @userID int, @chiTieuThem float
as
begin
	update TongChiTieuBanHang set TongChiTieu= TongChiTieu + @chiTieuThem where [userID]=@userID
end


GO
USE [master]
GO
ALTER DATABASE [QuanLyBanGiay] SET  READ_WRITE 
GO
