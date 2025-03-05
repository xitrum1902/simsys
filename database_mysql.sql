--
-- SQLINES DEMO *** se dump
--

-- SQLINES DEMO *** ase version 15.3
-- SQLINES DEMO ***  version 15.3

/* SET statement_timeout = 0; */
/* SET lock_timeout = 0; */
SET idle_in_transaction_session_timeout = 0;
/* SET client_encoding = 'UTF8'; */
/* SET standard_conforming_strings = on; */
-- SQLINES FOR EVALUATION USE ONLY (14 DAYS)
SELECT pg_catalog.set_config('search_path', '', false);
/* SET check_function_bodies = false; */
SET xmloption = content;
/* SET client_min_messages = warning; */
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- SQLINES DEMO *** ype: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    categoryid integer NOT NULL,
    name character varying(255),
    productid integer
);


ALTER TABLE public.category OWNER TO postgres;

--
-- SQLINES DEMO *** tegoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.category_categoryid_seq', 1, 1)
    NO 1;


ALTER TABLE public.category_categoryid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** tegoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_categoryid_seq OWNED BY public.category.categoryid;


--
-- SQLINES DEMO *** ; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consignment (
    consignmentid integer NOT NULL,
    sku character varying(255),
    name character varying(255),
    description longtext,
    totalquantity integer,
    totalprice numeric,
    importdate date,
    status longtext,
    supplierid integer,
    userid integer
);


ALTER TABLE public.consignment OWNER TO postgres;

--
-- SQLINES DEMO *** _ConsignmentID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.consignment_consignmentid_seq', 1, 1)
    NO 1;


ALTER TABLE public.consignment_consignmentid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** _ConsignmentID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consignment_consignmentid_seq OWNED BY public.consignment.consignmentid;


--
-- SQLINES DEMO *** ype: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customerid integer NOT NULL,
    name character varying(255),
    address longtext,
    phone character varying(20),
    email character varying(255),
    status boolean,
    bankcard character varying(20),
    createddate date,
    updateddate date
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- SQLINES DEMO *** stomerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.customer_customerid_seq', 1, 1)
    NO 1;


ALTER TABLE public.customer_customerid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** stomerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_customerid_seq OWNED BY public.customer.customerid;


--
-- SQLINES DEMO *** Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory (
    inventoryid integer NOT NULL,
    name character varying(255),
    address longtext,
    quantity integer,
    description longtext,
    locationid integer
);


ALTER TABLE public.inventory OWNER TO postgres;

--
-- SQLINES DEMO *** nventoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.inventory_inventoryid_seq', 1, 1)
    NO 1;


ALTER TABLE public.inventory_inventoryid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** nventoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventory_inventoryid_seq OWNED BY public.inventory.inventoryid;


--
-- SQLINES DEMO *** ype: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    locationid integer NOT NULL,
    locationname character varying(255),
    address longtext,
    description longtext,
    phonenumber character varying(20)
);


ALTER TABLE public.location OWNER TO postgres;

--
-- SQLINES DEMO *** cationID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.location_locationid_seq', 1, 1)
    NO 1;


ALTER TABLE public.location_locationid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** cationID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.location_locationid_seq OWNED BY public.location.locationid;


--
-- SQLINES DEMO *** : TABLE; Schema: public; Owner: postgres
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
-- SQLINES DEMO *** ; Type: TABLE; Schema: public; Owner: postgres
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
-- SQLINES DEMO *** _OrderDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.orderdetail_orderdetailid_seq', 1, 1)
    NO 1;


ALTER TABLE public.orderdetail_orderdetailid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** _OrderDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orderdetail_orderdetailid_seq OWNED BY public.orderdetail.orderdetailid;


--
-- SQLINES DEMO *** ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.order_orderid_seq', 1, 1)
    NO 1;


ALTER TABLE public.order_orderid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_orderid_seq OWNED BY public.order.orderid;


--
-- SQLINES DEMO *** il; Type: TABLE; Schema: public; Owner: postgres
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
-- SQLINES DEMO *** ilVariantValue; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productdetailvariantvalue (
    productdetailid integer NOT NULL,
    variantvalueid integer NOT NULL
);


ALTER TABLE public.productdetailvariantvalue OWNER TO postgres;

--
-- SQLINES DEMO *** il_ProductDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.productdetail_productdetailid_seq', 1, 1)
    NO 1;


ALTER TABLE public.productdetail_productdetailid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** il_ProductDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productdetail_productdetailid_seq OWNED BY public.productdetail.productdetailid;


--
-- SQLINES DEMO *** entory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_inventory (
    productinventoryid integer NOT NULL,
    productid integer,
    inventoryid integer,
    transferdate date
);


ALTER TABLE public.product_inventory OWNER TO postgres;

--
-- SQLINES DEMO *** entory_ProductInventoryID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.product_inventory_productinventoryid_seq', 1, 1)
    NO 1;


ALTER TABLE public.product_inventory_productinventoryid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** entory_ProductInventoryID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_inventory_productinventoryid_seq OWNED BY public.product_inventory.productinventoryid;


--
-- SQLINES DEMO *** pe: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    productid integer NOT NULL,
    name character varying(255),
    saleprice numeric,
    quantity integer,
    description longtext,
    status boolean,
    consignmentid integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- SQLINES DEMO *** ductID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.product_productid_seq', 1, 1)
    NO 1;


ALTER TABLE public.product_productid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** ductID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_productid_seq OWNED BY public.product.productid;


--
-- SQLINES DEMO *** er; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchaseorder (
    purchaseorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note longtext,
    totalamount numeric,
    status boolean,
    orderdate date
);


ALTER TABLE public.purchaseorder OWNER TO postgres;

--
-- SQLINES DEMO *** erDetail; Type: TABLE; Schema: public; Owner: postgres
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
-- SQLINES DEMO *** erDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.purchaseorderdetail_purchaseorderdetailid_seq', 1, 1)
    NO 1;


ALTER TABLE public.purchaseorderdetail_purchaseorderdetailid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** erDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq OWNED BY public.purchaseorderdetail.purchaseorderdetailid;


--
-- SQLINES DEMO *** er_PurchaseOrderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.purchaseorder_purchaseorderid_seq', 1, 1)
    NO 1;


ALTER TABLE public.purchaseorder_purchaseorderid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** er_PurchaseOrderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchaseorder_purchaseorderid_seq OWNED BY public.purchaseorder.purchaseorderid;


--
-- SQLINES DEMO *** r; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.requestorder (
    requestorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note longtext,
    userid integer,
    costprice numeric,
    status boolean,
    totalamount numeric,
    orderdate date,
    productdetailid integer,
    createdate date,
    description longtext
);


ALTER TABLE public.requestorder OWNER TO postgres;

--
-- SQLINES DEMO *** r_RequestOrderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.requestorder_requestorderid_seq', 1, 1)
    NO 1;


ALTER TABLE public.requestorder_requestorderid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** r_RequestOrderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.requestorder_requestorderid_seq OWNED BY public.requestorder.requestorderid;


--
-- SQLINES DEMO ***  TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    roleid integer NOT NULL,
    rolename character varying(255),
    description longtext
);


ALTER TABLE public.role OWNER TO postgres;

--
-- SQLINES DEMO *** _seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.role_roleid_seq', 1, 1)
    NO 1;


ALTER TABLE public.role_roleid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** _seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;


--
-- SQLINES DEMO *** ype: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    supplierid integer NOT NULL,
    name character varying(255),
    phone character varying(20),
    email character varying(255),
    address longtext,
    createddate date,
    updateddate date,
    rating numeric,
    userid integer
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- SQLINES DEMO *** formance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplierperformance (
    performanceid integer NOT NULL,
    supplierid integer,
    ontimedeliveryrate numeric,
    productqualityrating numeric,
    notes longtext,
    rulescompletionrate numeric,
    lastevaluated date,
    consignmentid integer,
    userid integer,
    status boolean
);


ALTER TABLE public.supplierperformance OWNER TO postgres;

--
-- SQLINES DEMO *** formanceDetail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplierperformancedetail (
    performancedetailid integer NOT NULL,
    performanceid integer,
    status boolean,
    variantvalueid integer
);


ALTER TABLE public.supplierperformancedetail OWNER TO postgres;

--
-- SQLINES DEMO *** formanceDetail_PerformanceDetailID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.supplierperformancedetail_performancedetailid_seq', 1, 1)
    NO 1;


ALTER TABLE public.supplierperformancedetail_performancedetailid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** formanceDetail_PerformanceDetailID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplierperformancedetail_performancedetailid_seq OWNED BY public.supplierperformancedetail.performancedetailid;


--
-- SQLINES DEMO *** formance_PerformanceID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.supplierperformance_performanceid_seq', 1, 1)
    NO 1;


ALTER TABLE public.supplierperformance_performanceid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** formance_PerformanceID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplierperformance_performanceid_seq OWNED BY public.supplierperformance.performanceid;


--
-- SQLINES DEMO *** pplierID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.supplier_supplierid_seq', 1, 1)
    NO 1;


ALTER TABLE public.supplier_supplierid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** pplierID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplier_supplierid_seq OWNED BY public.supplier.supplierid;


--
-- SQLINES DEMO *** g; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.systemconfig (
    configid integer NOT NULL,
    name character varying(255),
    configvalue longtext,
    description longtext
);


ALTER TABLE public.systemconfig OWNER TO postgres;

--
-- SQLINES DEMO *** g_ConfigID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.systemconfig_configid_seq', 1, 1)
    NO 1;


ALTER TABLE public.systemconfig_configid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** g_ConfigID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.systemconfig_configid_seq OWNED BY public.systemconfig.configid;


--
-- SQLINES DEMO *** ; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    transactionid integer NOT NULL,
    money numeric,
    note longtext,
    date date,
    userid integer,
    orderid integer
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- SQLINES DEMO *** _TransactionID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.transaction_transactionid_seq', 1, 1)
    NO 1;


ALTER TABLE public.transaction_transactionid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** _TransactionID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transaction_transactionid_seq OWNED BY public.transaction.transactionid;


--
-- SQLINES DEMO *** uest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transferrequest (
    transferid integer NOT NULL,
    note longtext,
    quantity integer,
    transferdate date,
    frominventoryid integer,
    toinventoryid integer,
    userid integer,
    variantvalueid integer
);


ALTER TABLE public.transferrequest OWNER TO postgres;

--
-- SQLINES DEMO *** uest_TransferID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.transferrequest_transferid_seq', 1, 1)
    NO 1;


ALTER TABLE public.transferrequest_transferid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** uest_TransferID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transferrequest_transferid_seq OWNED BY public.transferrequest.transferid;


--
-- SQLINES DEMO *** ory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_inventory (
    id integer NOT NULL,
    userid integer,
    status boolean,
    inventoryid integer
);


ALTER TABLE public.user_inventory OWNER TO postgres;

--
-- SQLINES DEMO *** ory_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.user_inventory_id_seq', 1, 1)
    NO 1;


ALTER TABLE public.user_inventory_id_seq OWNER TO postgres;

--
-- SQLINES DEMO *** ory_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_inventory_id_seq OWNED BY public.user_inventory.id;


--
-- SQLINES DEMO *** : TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    userid integer NOT NULL,
    username character varying(255),
    password character varying(255),
    roleid integer,
    email character varying(255),
    contactinfo longtext,
    createddate date,
    status boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- SQLINES DEMO *** D_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.users_userid_seq', 1, 1)
    NO 1;


ALTER TABLE public.users_userid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** D_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;


--
-- SQLINES DEMO *** pe: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant (
    variantid integer NOT NULL,
    name character varying(255),
    description longtext
);


ALTER TABLE public.variant OWNER TO postgres;

--
-- SQLINES DEMO *** e; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantvalue (
    variantvalueid integer NOT NULL,
    value character varying(255),
    variantid integer
);


ALTER TABLE public.variantvalue OWNER TO postgres;

--
-- SQLINES DEMO *** e_VariantValueID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.variantvalue_variantvalueid_seq', 1, 1)
    NO 1;


ALTER TABLE public.variantvalue_variantvalueid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** e_VariantValueID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.variantvalue_variantvalueid_seq OWNED BY public.variantvalue.variantvalueid;


--
-- SQLINES DEMO *** iantID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CALL CreateSequence('public.variant_variantid_seq', 1, 1)
    NO 1;


ALTER TABLE public.variant_variantid_seq OWNER TO postgres;

--
-- SQLINES DEMO *** iantID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.variant_variantid_seq OWNED BY public.variant.variantid;


--
-- SQLINES DEMO *** tegoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN categoryid SET DEFAULT nextval('public.category_categoryid_seq'::regclass);


--
-- SQLINES DEMO ***  ConsignmentID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment ALTER COLUMN consignmentid SET DEFAULT nextval('public.consignment_consignmentid_seq'::regclass);


--
-- SQLINES DEMO *** stomerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN customerid SET DEFAULT nextval('public.customer_customerid_seq'::regclass);


--
-- SQLINES DEMO *** nventoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory ALTER COLUMN inventoryid SET DEFAULT nextval('public.inventory_inventoryid_seq'::regclass);


--
-- SQLINES DEMO *** cationID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location ALTER COLUMN locationid SET DEFAULT nextval('public.location_locationid_seq'::regclass);


--
-- SQLINES DEMO *** ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order ALTER COLUMN orderid SET DEFAULT nextval('public.order_orderid_seq'::regclass);


--
-- SQLINES DEMO ***  OrderDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail ALTER COLUMN orderdetailid SET DEFAULT nextval('public.orderdetail_orderdetailid_seq'::regclass);


--
-- SQLINES DEMO *** il ProductDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail ALTER COLUMN productdetailid SET DEFAULT nextval('public.productdetail_productdetailid_seq'::regclass);


--
-- SQLINES DEMO *** entory ProductInventoryID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory ALTER COLUMN productinventoryid SET DEFAULT nextval('public.product_inventory_productinventoryid_seq'::regclass);


--
-- SQLINES DEMO *** er PurchaseOrderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder ALTER COLUMN purchaseorderid SET DEFAULT nextval('public.purchaseorder_purchaseorderid_seq'::regclass);


--
-- SQLINES DEMO *** erDetail PurchaseOrderDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail ALTER COLUMN purchaseorderdetailid SET DEFAULT nextval('public.purchaseorderdetail_purchaseorderdetailid_seq'::regclass);


--
-- SQLINES DEMO *** r RequestOrderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder ALTER COLUMN requestorderid SET DEFAULT nextval('public.requestorder_requestorderid_seq'::regclass);


--
-- SQLINES DEMO *** ; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);


--
-- SQLINES DEMO *** pplierID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier ALTER COLUMN supplierid SET DEFAULT nextval('public.supplier_supplierid_seq'::regclass);


--
-- SQLINES DEMO *** formance PerformanceID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance ALTER COLUMN performanceid SET DEFAULT nextval('public.supplierperformance_performanceid_seq'::regclass);


--
-- SQLINES DEMO *** formanceDetail PerformanceDetailID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail ALTER COLUMN performancedetailid SET DEFAULT nextval('public.supplierperformancedetail_performancedetailid_seq'::regclass);


--
-- SQLINES DEMO *** g ConfigID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemconfig ALTER COLUMN configid SET DEFAULT nextval('public.systemconfig_configid_seq'::regclass);


--
-- SQLINES DEMO ***  TransactionID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction ALTER COLUMN transactionid SET DEFAULT nextval('public.transaction_transactionid_seq'::regclass);


--
-- SQLINES DEMO *** uest TransferID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest ALTER COLUMN transferid SET DEFAULT nextval('public.transferrequest_transferid_seq'::regclass);


--
-- SQLINES DEMO *** ory ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory ALTER COLUMN id SET DEFAULT nextval('public.user_inventory_id_seq'::regclass);


--
-- SQLINES DEMO *** D; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);


--
-- SQLINES DEMO *** iantID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant ALTER COLUMN variantid SET DEFAULT nextval('public.variant_variantid_seq'::regclass);


--
-- SQLINES DEMO *** e VariantValueID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue ALTER COLUMN variantvalueid SET DEFAULT nextval('public.variantvalue_variantvalueid_seq'::regclass);


--
-- SQLINES DEMO *** ductid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN productid SET DEFAULT nextval('public.product_productid_seq'::regclass);


--
-- SQLINES DEMO *** tegory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category(categoryid, name, productid) FROM stdin;
\.


--
-- SQLINES DEMO *** nsignment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consignment(consignmentid, sku, name, description, totalquantity, totalprice, importdate, status, supplierid, userid) FROM stdin;
1	add-18-02-1	Lô hàng áo Adidas	lô hàng của adidas gồm nhiều loại áo	3	19000000	2025-02-18	pending	2	2
2	NK-18-02-1	Lô hàng áo Nike	lô hàng của nike gồm nhiều loại áo	2	11200000	2025-02-18	pending	1	1
\.


--
-- SQLINES DEMO *** stomer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer(customerid, name, address, phone, email, status, bankcard, createddate, updateddate) FROM stdin;
\.


--
-- SQLINES DEMO *** ventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventory(inventoryid, name, address, quantity, description, locationid) FROM stdin;
\.


--
-- SQLINES DEMO *** cation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location(locationid, locationname, address, description, phonenumber) FROM stdin;
\.


--
-- SQLINES DEMO *** der; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order(orderid, totalprice, orderdate, status, customerid, userid) FROM stdin;
\.


--
-- SQLINES DEMO *** derDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orderdetail(orderdetailid, quantity, userinventoryid, saleprice, orderid) FROM stdin;
\.


--
-- SQLINES DEMO *** oductDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productdetail(productdetailid, baseprice, status, importdate, productid, totalquantity) FROM stdin;
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
-- SQLINES DEMO *** oductDetailVariantValue; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productdetailvariantvalue(productdetailid, variantvalueid) FROM stdin;
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
-- SQLINES DEMO *** oduct_Inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_inventory(productinventoryid, productid, inventoryid, transferdate) FROM stdin;
\.


--
-- SQLINES DEMO *** rchaseOrder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchaseorder(purchaseorderid, supplierid, quantity, note, totalamount, status, orderdate) FROM stdin;
\.


--
-- SQLINES DEMO *** rchaseOrderDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchaseorderdetail(purchaseorderdetailid, purchaseorderid, productid, price, quantity, total) FROM stdin;
\.


--
-- SQLINES DEMO *** questOrder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.requestorder(requestorderid, supplierid, quantity, note, userid, costprice, status, totalamount, orderdate, productdetailid, createdate, description) FROM stdin;
\.


--
-- SQLINES DEMO *** le; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role(roleid, rolename, description) FROM stdin;
1	Admin	admin config system
2	staff	staff in the system
3	manager	manage the system
\.


--
-- SQLINES DEMO *** pplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier(supplierid, name, phone, email, address, createddate, updateddate, rating, userid) FROM stdin;
1	nike	0123456789	nike@gmail.com	210/c1	2025-02-18	2025-02-18	\N	1
2	adidas	0987654321	adidas@Gmail.com	211/c1	2025-02-18	2025-02-18	\N	2
\.


--
-- SQLINES DEMO *** pplierPerformance; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplierperformance(performanceid, supplierid, ontimedeliveryrate, productqualityrating, notes, rulescompletionrate, lastevaluated, consignmentid, userid, status) FROM stdin;
\.


--
-- SQLINES DEMO *** pplierPerformanceDetail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplierperformancedetail(performancedetailid, performanceid, status, variantvalueid) FROM stdin;
\.


--
-- SQLINES DEMO *** stemConfig; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.systemconfig(configid, name, configvalue, description) FROM stdin;
\.


--
-- SQLINES DEMO *** ansaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transaction(transactionid, money, note, date, userid, orderid) FROM stdin;
\.


--
-- SQLINES DEMO *** ansferRequest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transferrequest(transferid, note, quantity, transferdate, frominventoryid, toinventoryid, userid, variantvalueid) FROM stdin;
\.


--
-- SQLINES DEMO *** er_Inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_inventory(id, userid, status, inventoryid) FROM stdin;
\.


--
-- SQLINES DEMO *** ers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users(userid, username, password, roleid, email, contactinfo, createddate, status) FROM stdin;
1	nguyen anh tuan	123123	3	anhtuan@gmail.com	anhtuan@gmail.com	2025-02-18	t
2	dang duc toan	123123	3	ductoan@gmail.com	ductoan@gmail.com	2025-02-18	t
\.


--
-- SQLINES DEMO *** riant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variant(variantid, name, description) FROM stdin;
1	color	color of product
2	size	size of product
\.


--
-- SQLINES DEMO *** riantValue; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variantvalue(variantvalueid, value, variantid) FROM stdin;
1	L	2
2	M	2
3	blue	1
4	red	1
\.


--
-- SQLINES DEMO *** oduct; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product(productid, name, saleprice, quantity, description, status, consignmentid) FROM stdin;
4	áo sơ mi adidas	230000	50	áo sơ mi adidas	t	1
3	áo sơ mi Nike	180000	40	áo sơ mi nike	t	2
2	áo thun Adidas	250000	30	áo thun adidas	t	1
1	áo thun Nike	200000	20	áo thun nike	t	2
\.


--
-- SQLINES DEMO *** tegoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_categoryid_seq', 1, false);


--
-- SQLINES DEMO *** _ConsignmentID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consignment_consignmentid_seq', 1, false);


--
-- SQLINES DEMO *** stomerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_customerid_seq', 1, false);


--
-- SQLINES DEMO *** nventoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventory_inventoryid_seq', 1, false);


--
-- SQLINES DEMO *** cationID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.location_locationid_seq', 1, false);


--
-- SQLINES DEMO *** _OrderDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orderdetail_orderdetailid_seq', 1, false);


--
-- SQLINES DEMO *** ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_orderid_seq', 1, false);


--
-- SQLINES DEMO *** il_ProductDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productdetail_productdetailid_seq', 1, false);


--
-- SQLINES DEMO *** entory_ProductInventoryID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_inventory_productinventoryid_seq', 1, false);


--
-- SQLINES DEMO *** ductID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_productid_seq', 1, false);


--
-- SQLINES DEMO *** erDetail_PurchaseOrderDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchaseorderdetail_purchaseorderdetailid_seq', 1, false);


--
-- SQLINES DEMO *** er_PurchaseOrderID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchaseorder_purchaseorderid_seq', 1, false);


--
-- SQLINES DEMO *** r_RequestOrderID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.requestorder_requestorderid_seq', 1, false);


--
-- SQLINES DEMO *** _seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_roleid_seq', 1, false);


--
-- SQLINES DEMO *** formanceDetail_PerformanceDetailID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplierperformancedetail_performancedetailid_seq', 1, false);


--
-- SQLINES DEMO *** formance_PerformanceID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplierperformance_performanceid_seq', 1, false);


--
-- SQLINES DEMO *** pplierID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplier_supplierid_seq', 1, false);


--
-- SQLINES DEMO *** g_ConfigID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.systemconfig_configid_seq', 1, false);


--
-- SQLINES DEMO *** _TransactionID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transaction_transactionid_seq', 1, false);


--
-- SQLINES DEMO *** uest_TransferID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transferrequest_transferid_seq', 1, false);


--
-- SQLINES DEMO *** ory_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_inventory_id_seq', 1, false);


--
-- SQLINES DEMO *** D_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_userid_seq', 1, false);


--
-- SQLINES DEMO *** e_VariantValueID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.variantvalue_variantvalueid_seq', 1, false);


--
-- SQLINES DEMO *** iantID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.variant_variantid_seq', 1, false);


--
-- SQLINES DEMO *** tegory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY(categoryid);


--
-- SQLINES DEMO ***  Consignment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_pkey PRIMARY KEY(consignmentid);


--
-- SQLINES DEMO *** stomer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY(customerid);


--
-- SQLINES DEMO *** nventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY(inventoryid);


--
-- SQLINES DEMO *** cation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY(locationid);


--
-- SQLINES DEMO ***  OrderDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_pkey PRIMARY KEY(orderdetailid);


--
-- SQLINES DEMO *** _pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_pkey PRIMARY KEY(orderid);


--
-- SQLINES DEMO *** ilVariantValue PDVV_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_pkey PRIMARY KEY(productdetailid, variantvalueid);


--
-- SQLINES DEMO *** il ProductDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_pkey PRIMARY KEY(productdetailid);


--
-- SQLINES DEMO *** entory Product_Inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_pkey PRIMARY KEY(productinventoryid);


--
-- SQLINES DEMO *** duct_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY(productid);


--
-- SQLINES DEMO *** erDetail PurchaseOrderDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_pkey PRIMARY KEY(purchaseorderdetailid);


--
-- SQLINES DEMO *** er PurchaseOrder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_pkey PRIMARY KEY(purchaseorderid);


--
-- SQLINES DEMO *** r RequestOrder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_pkey PRIMARY KEY(requestorderid);


--
-- SQLINES DEMO *** key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY(roleid);


--
-- SQLINES DEMO *** formanceDetail SupplierPerformanceDetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_pkey PRIMARY KEY(performancedetailid);


--
-- SQLINES DEMO *** formance SupplierPerformance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_pkey PRIMARY KEY(performanceid);


--
-- SQLINES DEMO *** pplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY(supplierid);


--
-- SQLINES DEMO *** g SystemConfig_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemconfig
    ADD CONSTRAINT systemconfig_pkey PRIMARY KEY(configid);


--
-- SQLINES DEMO ***  Transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY(transactionid);


--
-- SQLINES DEMO *** uest TransferRequest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_pkey PRIMARY KEY(transferid);


--
-- SQLINES DEMO *** ory User_Inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_pkey PRIMARY KEY(id);


--
-- SQLINES DEMO *** _pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY(userid);


--
-- SQLINES DEMO *** e VariantValue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_pkey PRIMARY KEY(variantvalueid);


--
-- SQLINES DEMO *** iant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY(variantid);


--
-- SQLINES DEMO *** tegory_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_productid_fkey FOREIGN KEY(productid) REFERENCES public.product(productid);


--
-- SQLINES DEMO ***  Consignment_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_supplierid_fkey FOREIGN KEY(supplierid) REFERENCES public.supplier(supplierid);


--
-- SQLINES DEMO ***  Consignment_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** nventory_LocationID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_locationid_fkey FOREIGN KEY(locationid) REFERENCES public.location(locationid);


--
-- SQLINES DEMO ***  OrderDetail_OrderID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_orderid_fkey FOREIGN KEY(orderid) REFERENCES public.order(orderid);


--
-- SQLINES DEMO ***  OrderDetail_UserInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_userinventoryid_fkey FOREIGN KEY(userinventoryid) REFERENCES public.user_inventory(id);


--
-- SQLINES DEMO *** _CustomerID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_customerid_fkey FOREIGN KEY(customerid) REFERENCES public.customer(customerid);


--
-- SQLINES DEMO *** _UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order
    ADD CONSTRAINT order_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** ilVariantValue PDVV_ProductDetail_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_productdetail_fkey FOREIGN KEY(productdetailid) REFERENCES public.productdetail(productdetailid) ON DELETE CASCADE;


--
-- SQLINES DEMO *** ilVariantValue PDVV_VariantValue_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_variantvalue_fkey FOREIGN KEY(variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- SQLINES DEMO *** il ProductDetail_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_productid_fkey FOREIGN KEY(productid) REFERENCES public.product(productid);


--
-- SQLINES DEMO *** duct_ConsignmentID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_consignmentid_fkey FOREIGN KEY(consignmentid) REFERENCES public.consignment(consignmentid);


--
-- SQLINES DEMO *** entory Product_Inventory_InventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_inventoryid_fkey FOREIGN KEY(inventoryid) REFERENCES public.inventory(inventoryid);


--
-- SQLINES DEMO *** entory Product_Inventory_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_productid_fkey FOREIGN KEY(productid) REFERENCES public.product(productid);


--
-- SQLINES DEMO *** erDetail PurchaseOrderDetail_ProductID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_productid_fkey FOREIGN KEY(productid) REFERENCES public.product(productid);


--
-- SQLINES DEMO *** erDetail PurchaseOrderDetail_PurchaseOrderID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_purchaseorderid_fkey FOREIGN KEY(purchaseorderid) REFERENCES public.purchaseorder(purchaseorderid);


--
-- SQLINES DEMO *** er PurchaseOrder_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_supplierid_fkey FOREIGN KEY(supplierid) REFERENCES public.supplier(supplierid);


--
-- SQLINES DEMO *** r RequestOrder_ProductDetailID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_productdetailid_fkey FOREIGN KEY(productdetailid) REFERENCES public.productdetail(productdetailid);


--
-- SQLINES DEMO *** r RequestOrder_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_supplierid_fkey FOREIGN KEY(supplierid) REFERENCES public.supplier(supplierid);


--
-- SQLINES DEMO *** r RequestOrder_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.requestorder
    ADD CONSTRAINT requestorder_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** formanceDetail SupplierPerformanceDetail_PerformanceID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_performanceid_fkey FOREIGN KEY(performanceid) REFERENCES public.supplierperformance(performanceid);


--
-- SQLINES DEMO *** formanceDetail SupplierPerformanceDetail_VariantValueID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_variantvalueid_fkey FOREIGN KEY(variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- SQLINES DEMO *** formance SupplierPerformance_ConsignmentID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_consignmentid_fkey FOREIGN KEY(consignmentid) REFERENCES public.consignment(consignmentid);


--
-- SQLINES DEMO *** formance SupplierPerformance_SupplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_supplierid_fkey FOREIGN KEY(supplierid) REFERENCES public.supplier(supplierid);


--
-- SQLINES DEMO *** formance SupplierPerformance_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** pplier_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO ***  Transaction_OrderId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_orderid_fkey FOREIGN KEY(orderid) REFERENCES public.order(orderid);


--
-- SQLINES DEMO ***  Transaction_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** uest TransferRequest_FromInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_frominventoryid_fkey FOREIGN KEY(frominventoryid) REFERENCES public.inventory(inventoryid);


--
-- SQLINES DEMO *** uest TransferRequest_ToInventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_toinventoryid_fkey FOREIGN KEY(toinventoryid) REFERENCES public.inventory(inventoryid);


--
-- SQLINES DEMO *** uest TransferRequest_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** uest TransferRequest_VariantValueID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_variantvalueid_fkey FOREIGN KEY(variantvalueid) REFERENCES public.variantvalue(variantvalueid);


--
-- SQLINES DEMO *** ory User_Inventory_InventoryID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_inventoryid_fkey FOREIGN KEY(inventoryid) REFERENCES public.inventory(inventoryid);


--
-- SQLINES DEMO *** ory User_Inventory_UserID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_userid_fkey FOREIGN KEY(userid) REFERENCES public.users(userid);


--
-- SQLINES DEMO *** _RoleID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roleid_fkey FOREIGN KEY(roleid) REFERENCES public.role(roleid);


--
-- SQLINES DEMO *** e VariantValue_VariantID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_variantid_fkey FOREIGN KEY(variantid) REFERENCES public.variant(variantid);


--
-- SQLINES DEMO *** se dump complete
--

