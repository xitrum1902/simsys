--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    categoryid integer NOT NULL,
    name character varying(255),
    productid integer
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: Category_CategoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_categoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_categoryid_seq OWNER TO postgres;

--
-- Name: Category_CategoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_categoryid_seq OWNED BY public.category.categoryid;


--
-- Name: Consignment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consignment (
    consignmentid integer NOT NULL,
    sku character varying(255),
    name character varying(255),
    description text,
    totalquantity integer,
    totalprice numeric,
    importdate date,
    status text,
    supplierid integer,
    userid integer
);


ALTER TABLE public.consignment OWNER TO postgres;

--
-- Name: Consignment_ConsignmentID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consignment_consignmentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consignment_consignmentid_seq OWNER TO postgres;

--
-- Name: Consignment_ConsignmentID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consignment_consignmentid_seq OWNED BY public.consignment.consignmentid;


--
-- Name: Customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customerid integer NOT NULL,
    name character varying(255),
    address text,
    phone character varying(20),
    email character varying(255),
    status boolean,
    bankcard character varying(20),
    createddate date,
    updateddate date
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: Customer_CustomerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_customerid_seq OWNER TO postgres;

--
-- Name: Customer_CustomerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_customerid_seq OWNED BY public.customer.customerid;


--
-- Name: Inventory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory (
    inventoryid integer NOT NULL,
    name character varying(255),
    address text,
    quantity integer,
    description text,
    locationid integer
);


ALTER TABLE public.inventory OWNER TO postgres;

--
-- Name: Inventory_InventoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inventory_inventoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inventory_inventoryid_seq OWNER TO postgres;

--
-- Name: Inventory_InventoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventory_inventoryid_seq OWNED BY public.inventory.inventoryid;


--
-- Name: Location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    locationid integer NOT NULL,
    locationname character varying(255),
    address text,
    description text,
    phonenumber character varying(20)
);


ALTER TABLE public.location OWNER TO postgres;

--
-- Name: Location_LocationID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.location_locationid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.location_locationid_seq OWNER TO postgres;

--
-- Name: Location_LocationID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.location_locationid_seq OWNED BY public.location.locationid;


--
-- Name: Order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order (
    orderid integer NOT NULL,
    totalprice numeric,
    orderdate date,
    status boolean,
    customerid integer,
    userid integer
);


ALTER TABLE public.order OWNER TO postgres;

--
-- Name: OrderDetail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orderdetail (
    orderdetailid integer NOT NULL,
    quantity integer,
    userinventoryid integer,
    saleprice numeric,
    orderid integer
);


ALTER TABLE public.orderdetail OWNER TO postgres;

--
-- Name: OrderDetail_OrderDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orderdetail_orderdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orderdetail_orderdetailid_seq OWNER TO postgres;

--
-- Name: OrderDetail_OrderDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orderdetail_orderdetailid_seq OWNED BY public.orderdetail.orderdetailid;


--
-- Name: Order_OrderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_orderid_seq OWNER TO postgres;

--
-- Name: Order_OrderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_orderid_seq OWNED BY public.order.orderid;


--
-- Name: ProductDetail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productdetail (
    productdetailid integer NOT NULL,
    baseprice numeric,
    status boolean,
    importdate date,
    productid integer,
    totalquantity numeric
);


ALTER TABLE public.productdetail OWNER TO postgres;

--
-- Name: ProductDetailVariantValue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productdetailvariantvalue (
    productdetailid integer NOT NULL,
    variantvalueid integer NOT NULL
);


ALTER TABLE public.productdetailvariantvalue OWNER TO postgres;

--
-- Name: ProductDetail_ProductDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productdetail_productdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productdetail_productdetailid_seq OWNER TO postgres;

--
-- Name: ProductDetail_ProductDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productdetail_productdetailid_seq OWNED BY public.productdetail.productdetailid;


--
-- Name: Product_Inventory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_inventory (
    productinventoryid integer NOT NULL,
    productid integer,
    inventoryid integer,
    transferdate date
);


ALTER TABLE public.product_inventory OWNER TO postgres;

--
-- Name: Product_Inventory_ProductInventoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_inventory_productinventoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_inventory_productinventoryid_seq OWNER TO postgres;

--
-- Name: Product_Inventory_ProductInventoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_inventory_productinventoryid_seq OWNED BY public.product_inventory.productinventoryid;


--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    productid integer NOT NULL,
    name character varying(255),
    saleprice numeric,
    quantity integer,
    description text,
    status boolean,
    consignmentid integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: Product_ProductID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_productid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_productid_seq OWNER TO postgres;

--
-- Name: Product_ProductID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_productid_seq OWNED BY public.product.productid;


--
-- Name: PurchaseOrder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchaseorder (
    purchaseorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note text,
    totalamount numeric,
    status boolean,
    orderdate date
);


ALTER TABLE public.purchaseorder OWNER TO postgres;

--
-- Name: PurchaseOrderDetail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchaseorderdetail (
    purchaseorderdetailid integer NOT NULL,
    purchaseorderid integer,
    productid integer,
    price numeric,
    quantity integer,
    total numeric
);


ALTER TABLE public.purchaseorderdetail OWNER TO postgres;

--
-- Name: PurchaseOrderDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchaseorderdetail_purchaseorderdetailid_seq OWNER TO postgres;

--
-- Name: PurchaseOrderDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq OWNED BY public.purchaseorderdetail.purchaseorderdetailid;


--
-- Name: PurchaseOrder_PurchaseOrderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchaseorder_purchaseorderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchaseorder_purchaseorderid_seq OWNER TO postgres;

--
-- Name: PurchaseOrder_PurchaseOrderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchaseorder_purchaseorderid_seq OWNED BY public.purchaseorder.purchaseorderid;


--
-- Name: RequestOrder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.requestorder (
    requestorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note text,
    userid integer,
    costprice numeric,
    status boolean,
    totalamount numeric,
    orderdate date,
    productdetailid integer,
    createdate date,
    description text
);


ALTER TABLE public.requestorder OWNER TO postgres;

--
-- Name: RequestOrder_RequestOrderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.requestorder_requestorderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.requestorder_requestorderid_seq OWNER TO postgres;

--
-- Name: RequestOrder_RequestOrderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.requestorder_requestorderid_seq OWNED BY public.requestorder.requestorderid;


--
-- Name: Role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    roleid integer NOT NULL,
    rolename character varying(255),
    description text
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: Role_RoleID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_roleid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_roleid_seq OWNER TO postgres;

--
-- Name: Role_RoleID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;


--
-- Name: Supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    supplierid integer NOT NULL,
    name character varying(255),
    phone character varying(20),
    email character varying(255),
    address text,
    createddate date,
    updateddate date,
    rating numeric,
    userid integer
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- Name: SupplierPerformance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplierperformance (
    performanceid integer NOT NULL,
    supplierid integer,
    ontimedeliveryrate numeric,
    productqualityrating numeric,
    notes text,
    rulescompletionrate numeric,
    lastevaluated date,
    consignmentid integer,
    userid integer,
    status boolean
);


ALTER TABLE public.supplierperformance OWNER TO postgres;

--
-- Name: SupplierPerformanceDetail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplierperformancedetail (
    performancedetailid integer NOT NULL,
    performanceid integer,
    status boolean,
    variantvalueid integer
);


ALTER TABLE public.supplierperformancedetail OWNER TO postgres;

--
-- Name: SupplierPerformanceDetail_PerformanceDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplierperformancedetail_performancedetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supplierperformancedetail_performancedetailid_seq OWNER TO postgres;

--
-- Name: SupplierPerformanceDetail_PerformanceDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplierperformancedetail_performancedetailid_seq OWNED BY public.supplierperformancedetail.performancedetailid;


--
-- Name: SupplierPerformance_PerformanceID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplierperformance_performanceid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supplierperformance_performanceid_seq OWNER TO postgres;

--
-- Name: SupplierPerformance_PerformanceID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplierperformance_performanceid_seq OWNED BY public.supplierperformance.performanceid;


--
-- Name: Supplier_SupplierID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplier_supplierid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supplier_supplierid_seq OWNER TO postgres;

--
-- Name: Supplier_SupplierID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplier_supplierid_seq OWNED BY public.supplier.supplierid;


--
-- Name: SystemConfig; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.systemconfig (
    configid integer NOT NULL,
    name character varying(255),
    configvalue text,
    description text
);


ALTER TABLE public.systemconfig OWNER TO postgres;

--
-- Name: SystemConfig_ConfigID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.systemconfig_configid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.systemconfig_configid_seq OWNER TO postgres;

--
-- Name: SystemConfig_ConfigID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.systemconfig_configid_seq OWNED BY public.systemconfig.configid;


--
-- Name: Transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    transactionid integer NOT NULL,
    money numeric,
    note text,
    date date,
    userid integer,
    orderid integer
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- Name: Transaction_TransactionID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transaction_transactionid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transaction_transactionid_seq OWNER TO postgres;

--
-- Name: Transaction_TransactionID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transaction_transactionid_seq OWNED BY public.transaction.transactionid;


--
-- Name: TransferRequest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transferrequest (
    transferid integer NOT NULL,
    note text,
    quantity integer,
    transferdate date,
    frominventoryid integer,
    toinventoryid integer,
    userid integer,
    variantvalueid integer
);


ALTER TABLE public.transferrequest OWNER TO postgres;

--
-- Name: TransferRequest_TransferID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transferrequest_transferid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transferrequest_transferid_seq OWNER TO postgres;

--
-- Name: TransferRequest_TransferID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transferrequest_transferid_seq OWNED BY public.transferrequest.transferid;


--
-- Name: User_Inventory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_inventory (
    id integer NOT NULL,
    userid integer,
    status boolean,
    inventoryid integer
);


ALTER TABLE public.user_inventory OWNER TO postgres;

--
-- Name: User_Inventory_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_inventory_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_inventory_id_seq OWNER TO postgres;

--
-- Name: User_Inventory_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_inventory_id_seq OWNED BY public.user_inventory.id;


--
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    userid integer NOT NULL,
    username character varying(255),
    password character varying(255),
    roleid integer,
    email character varying(255),
    contactinfo text,
    createddate date,
    status boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: Users_UserID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_userid_seq OWNER TO postgres;

--
-- Name: Users_UserID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;


--
-- Name: Variant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant (
    variantid integer NOT NULL,
    name character varying(255),
    description text
);


ALTER TABLE public.variant OWNER TO postgres;

--
-- Name: VariantValue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantvalue (
    variantvalueid integer NOT NULL,
    value character varying(255),
    variantid integer
);


ALTER TABLE public.variantvalue OWNER TO postgres;

--
-- Name: VariantValue_VariantValueID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.variantvalue_variantvalueid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.variantvalue_variantvalueid_seq OWNER TO postgres;

--
-- Name: VariantValue_VariantValueID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.variantvalue_variantvalueid_seq OWNED BY public.variantvalue.variantvalueid;


--
-- Name: Variant_VariantID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.variant_variantid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.variant_variantid_seq OWNER TO postgres;

--
-- Name: Variant_VariantID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.variant_variantid_seq OWNED BY public.variant.variantid;


--
-- Name: Category CategoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN categoryid SET DEFAULT nextval('public.category_categoryid_seq'::regclass);


--
-- Name: Consignment ConsignmentID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment ALTER COLUMN consignmentid SET DEFAULT nextval('public.consignment_consignmentid_seq'::regclass);


--
-- Name: Customer CustomerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN customerid SET DEFAULT nextval('public.customer_customerid_seq'::regclass);


--
-- Name: Inventory InventoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory ALTER COLUMN inventoryid SET DEFAULT nextval('public.inventory_inventoryid_seq'::regclass);


--
-- Name: Location LocationID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location ALTER COLUMN locationid SET DEFAULT nextval('public.location_locationid_seq'::regclass);


--
-- Name: Order OrderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order ALTER COLUMN orderid SET DEFAULT nextval('public.order_orderid_seq'::regclass);


--
-- Name: OrderDetail OrderDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail ALTER COLUMN orderdetailid SET DEFAULT nextval('public.orderdetail_orderdetailid_seq'::regclass);


--
-- Name: ProductDetail ProductDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail ALTER COLUMN productdetailid SET DEFAULT nextval('public.productdetail_productdetailid_seq'::regclass);


--
-- Name: Product_Inventory ProductInventoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory ALTER COLUMN productinventoryid SET DEFAULT nextval('public.product_inventory_productinventoryid_seq'::regclass);


--
-- Name: PurchaseOrder PurchaseOrderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder ALTER COLUMN purchaseorderid SET DEFAULT nextval('public.purchaseorder_purchaseorderid_seq'::regclass);


--
-- Name: PurchaseOrderDetail PurchaseOrderDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail ALTER COLUMN purchaseorderdetailid SET DEFAULT nextval('public.purchaseorderdetail_purchaseorderdetailid_seq'::regclass);


--
-- Name: RequestOrder RequestOrderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder ALTER COLUMN requestorderid SET DEFAULT nextval('public.requestorder_requestorderid_seq'::regclass);


--
-- Name: Role RoleID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);


--
-- Name: Supplier SupplierID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier ALTER COLUMN supplierid SET DEFAULT nextval('public.supplier_supplierid_seq'::regclass);


--
-- Name: SupplierPerformance PerformanceID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance ALTER COLUMN performanceid SET DEFAULT nextval('public.supplierperformance_performanceid_seq'::regclass);


--
-- Name: SupplierPerformanceDetail PerformanceDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail ALTER COLUMN performancedetailid SET DEFAULT nextval('public.supplierperformancedetail_performancedetailid_seq'::regclass);


--
-- Name: SystemConfig ConfigID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemconfig ALTER COLUMN configid SET DEFAULT nextval('public.systemconfig_configid_seq'::regclass);


--
-- Name: Transaction TransactionID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction ALTER COLUMN transactionid SET DEFAULT nextval('public.transaction_transactionid_seq'::regclass);


--
-- Name: TransferRequest TransferID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest ALTER COLUMN transferid SET DEFAULT nextval('public.transferrequest_transferid_seq'::regclass);


--
-- Name: User_Inventory ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory ALTER COLUMN id SET DEFAULT nextval('public.user_inventory_id_seq'::regclass);


--
-- Name: Users UserID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);


--
-- Name: Variant VariantID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant ALTER COLUMN variantid SET DEFAULT nextval('public.variant_variantid_seq'::regclass);


--
-- Name: VariantValue VariantValueID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue ALTER COLUMN variantvalueid SET DEFAULT nextval('public.variantvalue_variantvalueid_seq'::regclass);


--
-- Name: product productid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN productid SET DEFAULT nextval('public.product_productid_seq'::regclass);


--
-- Data for Name: Category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (categoryid, name, productid) FROM stdin;
\.


--
-- Data for Name: Consignment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consignment (consignmentid, sku, name, description, totalquantity, totalprice, importdate, status, supplierid, userid) FROM stdin;
1	add-18-02-1	Lô hàng áo Adidas	lô hàng của adidas gồm nhiều loại áo	3	19000000	2025-02-18	pending	2	2
2	NK-18-02-1	Lô hàng áo Nike	lô hàng của nike gồm nhiều loại áo	2	11200000	2025-02-18	pending	1	1
\.


--
-- Data for Name: Customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customerid, name, address, phone, email, status, bankcard, createddate, updateddate) FROM stdin;
\.


--
-- Data for Name: Inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventory (inventoryid, name, address, quantity, description, locationid) FROM stdin;
\.


--
-- Data for Name: Location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (locationid, locationname, address, description, phonenumber) FROM stdin;
\.


--
-- Data for Name: Order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order (orderid, totalprice, orderdate, status, customerid, userid) FROM stdin;
\.


--
-- Data for Name: OrderDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orderdetail (orderdetailid, quantity, userinventoryid, saleprice, orderid) FROM stdin;
\.


--
-- Data for Name: ProductDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productdetail (productdetailid, baseprice, status, importdate, productid, totalquantity) FROM stdin;
1	200000	t	2025-02-18	1	9
2	200000	t	2025-02-18	1	11
3	250000	t	2025-02-18	2	10
4	250000	t	2025-02-18	2	20
5	180000	t	2025-02-18	3	15
6	180000	t	2025-02-18	3	25
7	230000	t	2025-02-18	4	10
8	230000	t	2025-02-18	4	40
\.


--
-- Data for Name: ProductDetailVariantValue; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productdetailvariantvalue (productdetailid, variantvalueid) FROM stdin;
1	4
1	1
2	3
2	2
3	2
3	4
4	1
4	3
5	1
8	4
5	4
\.


--
-- Data for Name: Product_Inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_inventory (productinventoryid, productid, inventoryid, transferdate) FROM stdin;
\.


--
-- Data for Name: PurchaseOrder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchaseorder (purchaseorderid, supplierid, quantity, note, totalamount, status, orderdate) FROM stdin;
\.


--
-- Data for Name: PurchaseOrderDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchaseorderdetail (purchaseorderdetailid, purchaseorderid, productid, price, quantity, total) FROM stdin;
\.


--
-- Data for Name: RequestOrder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.requestorder (requestorderid, supplierid, quantity, note, userid, costprice, status, totalamount, orderdate, productdetailid, createdate, description) FROM stdin;
\.


--
-- Data for Name: Role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (roleid, rolename, description) FROM stdin;
1	Admin	admin config system
2	staff	staff in the system
3	manager	manage the system
\.


--
-- Data for Name: Supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (supplierid, name, phone, email, address, createddate, updateddate, rating, userid) FROM stdin;
1	nike	0123456789	nike@gmail.com	210/c1	2025-02-18	2025-02-18	\N	1
2	adidas	0987654321	adidas@Gmail.com	211/c1	2025-02-18	2025-02-18	\N	2
\.


--
-- Data for Name: SupplierPerformance; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplierperformance (performanceid, supplierid, ontimedeliveryrate, productqualityrating, notes, rulescompletionrate, lastevaluated, consignmentid, userid, status) FROM stdin;
\.


--
-- Data for Name: SupplierPerformanceDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplierperformancedetail (performancedetailid, performanceid, status, variantvalueid) FROM stdin;
\.


--
-- Data for Name: SystemConfig; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.systemconfig (configid, name, configvalue, description) FROM stdin;
\.


--
-- Data for Name: Transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transaction (transactionid, money, note, date, userid, orderid) FROM stdin;
\.


--
-- Data for Name: TransferRequest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transferrequest (transferid, note, quantity, transferdate, frominventoryid, toinventoryid, userid, variantvalueid) FROM stdin;
\.


--
-- Data for Name: User_Inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_inventory (id, userid, status, inventoryid) FROM stdin;
\.


--
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (userid, username, password, roleid, email, contactinfo, createddate, status) FROM stdin;
1	nguyen anh tuan	123123	3	anhtuan@gmail.com	anhtuan@gmail.com	2025-02-18	t
2	dang duc toan	123123	3	ductoan@gmail.com	ductoan@gmail.com	2025-02-18	t
\.


--
-- Data for Name: Variant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variant (variantid, name, description) FROM stdin;
1	color	color of product
2	size	size of product
\.


--
-- Data for Name: VariantValue; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variantvalue (variantvalueid, value, variantid) FROM stdin;
1	L	2
2	M	2
3	blue	1
4	red	1
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (productid, name, saleprice, quantity, description, status, consignmentid) FROM stdin;
4	áo sơ mi adidas	230000	50	áo sơ mi adidas	t	1
3	áo sơ mi Nike	180000	40	áo sơ mi nike	t	2
2	áo thun Adidas	250000	30	áo thun adidas	t	1
1	áo thun Nike	200000	20	áo thun nike	t	2
\.


--
-- Name: Category_CategoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_categoryid_seq', 1, false);


--
-- Name: Consignment_ConsignmentID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consignment_consignmentid_seq', 1, false);


--
-- Name: Customer_CustomerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_customerid_seq', 1, false);


--
-- Name: Inventory_InventoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventory_inventoryid_seq', 1, false);


--
-- Name: Location_LocationID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.location_locationid_seq', 1, false);


--
-- Name: OrderDetail_OrderDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orderdetail_orderdetailid_seq', 1, false);


--
-- Name: Order_OrderID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_orderid_seq', 1, false);


--
-- Name: ProductDetail_ProductDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productdetail_productdetailid_seq', 1, false);


--
-- Name: Product_Inventory_ProductInventoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_inventory_productinventoryid_seq', 1, false);


--
-- Name: Product_ProductID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_productid_seq', 1, false);


--
-- Name: PurchaseOrderDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchaseorderdetail_purchaseorderdetailid_seq', 1, false);


--
-- Name: PurchaseOrder_PurchaseOrderID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchaseorder_purchaseorderid_seq', 1, false);


--
-- Name: RequestOrder_RequestOrderID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.requestorder_requestorderid_seq', 1, false);


--
-- Name: Role_RoleID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_roleid_seq', 1, false);


--
-- Name: SupplierPerformanceDetail_PerformanceDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplierperformancedetail_performancedetailid_seq', 1, false);


--
-- Name: SupplierPerformance_PerformanceID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplierperformance_performanceid_seq', 1, false);


--
-- Name: Supplier_SupplierID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplier_supplierid_seq', 1, false);


--
-- Name: SystemConfig_ConfigID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.systemconfig_configid_seq', 1, false);


--
-- Name: Transaction_TransactionID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transaction_transactionid_seq', 1, false);


--
-- Name: TransferRequest_TransferID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transferrequest_transferid_seq', 1, false);


--
-- Name: User_Inventory_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_inventory_id_seq', 1, false);


--
-- Name: Users_UserID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_userid_seq', 1, false);


--
-- Name: VariantValue_VariantValueID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.variantvalue_variantvalueid_seq', 1, false);


--
-- Name: Variant_VariantID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.variant_variantid_seq', 1, false);


--
-- Name: Category Category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (categoryid);


--
-- Name: Consignment Consignment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_pkey PRIMARY KEY (consignmentid);


--
-- Name: Customer Customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customerid);


--
-- Name: Inventory Inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (inventoryid);


--
-- Name: Location Location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (locationid);


--
-- Name: OrderDetail OrderDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_pkey PRIMARY KEY (orderdetailid);


--
-- Name: Order Order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_pkey PRIMARY KEY (orderid);


--
-- Name: ProductDetailVariantValue PDVV_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_pkey PRIMARY KEY (productdetailid, variantvalueid);


--
-- Name: ProductDetail ProductDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_pkey PRIMARY KEY (productdetailid);


--
-- Name: Product_Inventory Product_Inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_pkey PRIMARY KEY (productinventoryid);


--
-- Name: product Product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (productid);


--
-- Name: PurchaseOrderDetail PurchaseOrderDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_pkey PRIMARY KEY (purchaseorderdetailid);


--
-- Name: PurchaseOrder PurchaseOrder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_pkey PRIMARY KEY (purchaseorderid);


--
-- Name: RequestOrder RequestOrder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_pkey PRIMARY KEY (requestorderid);


--
-- Name: Role Role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);


--
-- Name: SupplierPerformanceDetail SupplierPerformanceDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_pkey PRIMARY KEY (performancedetailid);


--
-- Name: SupplierPerformance SupplierPerformance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_pkey PRIMARY KEY (performanceid);


--
-- Name: Supplier Supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (supplierid);


--
-- Name: SystemConfig SystemConfig_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemconfig
    ADD CONSTRAINT systemconfig_pkey PRIMARY KEY (configid);


--
-- Name: Transaction Transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (transactionid);


--
-- Name: TransferRequest TransferRequest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_pkey PRIMARY KEY (transferid);


--
-- Name: User_Inventory User_Inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_pkey PRIMARY KEY (id);


--
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);


--
-- Name: VariantValue VariantValue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_pkey PRIMARY KEY (variantvalueid);


--
-- Name: Variant Variant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY (variantid);


--
-- Name: Category Category_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: Consignment Consignment_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);


--
-- Name: Consignment Consignment_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: Inventory Inventory_LocationID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_locationid_fkey FOREIGN KEY (locationid) REFERENCES public.location(locationid);


--
-- Name: OrderDetail OrderDetail_OrderID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_orderid_fkey FOREIGN KEY (orderid) REFERENCES public.order(orderid);


--
-- Name: OrderDetail OrderDetail_UserInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_userinventoryid_fkey FOREIGN KEY (userinventoryid) REFERENCES public.user_inventory(id);


--
-- Name: Order Order_CustomerID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_customerid_fkey FOREIGN KEY (customerid) REFERENCES public.customer(customerid);


--
-- Name: Order Order_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: ProductDetailVariantValue PDVV_ProductDetail_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_productdetail_fkey FOREIGN KEY (productdetailid) REFERENCES public.productdetail(productdetailid) ON DELETE CASCADE;


--
-- Name: ProductDetailVariantValue PDVV_VariantValue_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_variantvalue_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- Name: ProductDetail ProductDetail_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: product Product_ConsignmentID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_consignmentid_fkey FOREIGN KEY (consignmentid) REFERENCES public.consignment(consignmentid);


--
-- Name: Product_Inventory Product_Inventory_InventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_inventoryid_fkey FOREIGN KEY (inventoryid) REFERENCES public.inventory(inventoryid);


--
-- Name: Product_Inventory Product_Inventory_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: PurchaseOrderDetail PurchaseOrderDetail_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: PurchaseOrderDetail PurchaseOrderDetail_PurchaseOrderID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_purchaseorderid_fkey FOREIGN KEY (purchaseorderid) REFERENCES public.purchaseorder(purchaseorderid);


--
-- Name: PurchaseOrder PurchaseOrder_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);


--
-- Name: RequestOrder RequestOrder_ProductDetailID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_productdetailid_fkey FOREIGN KEY (productdetailid) REFERENCES public.productdetail(productdetailid);


--
-- Name: RequestOrder RequestOrder_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);


--
-- Name: RequestOrder RequestOrder_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: SupplierPerformanceDetail SupplierPerformanceDetail_PerformanceID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_performanceid_fkey FOREIGN KEY (performanceid) REFERENCES public.supplierperformance(performanceid);


--
-- Name: SupplierPerformanceDetail SupplierPerformanceDetail_VariantValueID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_variantvalueid_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- Name: SupplierPerformance SupplierPerformance_ConsignmentID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_consignmentid_fkey FOREIGN KEY (consignmentid) REFERENCES public.consignment(consignmentid);


--
-- Name: SupplierPerformance SupplierPerformance_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);


--
-- Name: SupplierPerformance SupplierPerformance_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: Supplier Supplier_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: Transaction Transaction_OrderId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_orderid_fkey FOREIGN KEY (orderid) REFERENCES public.order(orderid);


--
-- Name: Transaction Transaction_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: TransferRequest TransferRequest_FromInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_frominventoryid_fkey FOREIGN KEY (frominventoryid) REFERENCES public.inventory(inventoryid);


--
-- Name: TransferRequest TransferRequest_ToInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_toinventoryid_fkey FOREIGN KEY (toinventoryid) REFERENCES public.inventory(inventoryid);


--
-- Name: TransferRequest TransferRequest_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: TransferRequest TransferRequest_VariantValueID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_variantvalueid_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- Name: User_Inventory User_Inventory_InventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_inventoryid_fkey FOREIGN KEY (inventoryid) REFERENCES public.inventory(inventoryid);


--
-- Name: User_Inventory User_Inventory_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: Users Users_RoleID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.role(roleid);


--
-- Name: VariantValue VariantValue_VariantID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_variantid_fkey FOREIGN KEY (variantid) REFERENCES public.variant(variantid);


--
-- PostgreSQL database dump complete
--

