CREATE KEYSPACE booking_orch WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
use booking_orch;

CREATE TABLE booking_orch.orders_by_user (
tenant text,
user_id text,
sub_group text,
order_id uuid,
property text,
timestamp timestamp,
value text,
PRIMARY KEY ((tenant, user_id, sub_group), order_id, property, timestamp)
) WITH CLUSTERING ORDER BY (order_id ASC, property DESC, timestamp DESC);

CREATE TABLE booking_orch.polyline_by_order (
tenant text,
order_id uuid,
type int,
polyline text,
PRIMARY KEY ((tenant, order_id), type)
) WITH CLUSTERING ORDER BY (type ASC);

CREATE TABLE booking_orch.orders_weeks_8 (
tenant text,
id uuid,
property text,
timestamp timestamp,
value text,
PRIMARY KEY ((tenant, id), property, timestamp)
) WITH CLUSTERING ORDER BY (property DESC, timestamp DESC);

CREATE TABLE booking_orch.orders (
tenant text,
id uuid,
property text,
timestamp timestamp,
value text,
PRIMARY KEY ((tenant, id), property, timestamp)
) WITH CLUSTERING ORDER BY (property DESC, timestamp DESC);

CREATE TABLE booking_orch.orders_by_time (
tenant text,
year int,
month int,
day int,
hour int,
created_at timestamp,
order_id uuid,
data map<text, text>,
PRIMARY KEY ((tenant, year, month, day, hour), created_at, order_id)
) WITH CLUSTERING ORDER BY (created_at DESC, order_id ASC);

CREATE TABLE booking_orch.orders_by_yard (
tenant text,
yard_id text,
shard text,
order_id uuid,
data map<text, text>,
status text,
PRIMARY KEY ((tenant, yard_id, shard), order_id)
) WITH CLUSTERING ORDER BY (order_id ASC);

CREATE TABLE booking_orch.orders_generic_data (
tenant text,
order_id uuid,
key text,
data text,
PRIMARY KEY ((tenant, order_id, key))
);

CREATE TABLE booking_orch.sd_orders_by_yard_end_time (
tenant text,
yard_id text,
shard text,
order_id uuid,
data map<text, text>,
PRIMARY KEY ((tenant, yard_id, shard), order_id)
) WITH CLUSTERING ORDER BY (order_id ASC);

CREATE TABLE booking_orch.order_by_crn (
tenant text,
crn text,
order_id uuid,
PRIMARY KEY ((tenant, crn))
);

CREATE TABLE booking_orch.order_id_details (
order_id uuid PRIMARY KEY,
pickup_time_bucket timestamp,
program text,
sub_program text,
tenant text,
user_id text,
version int
);

CREATE TABLE booking_orch.orders_weeks_5 (
tenant text,
id uuid,
property text,
timestamp timestamp,
value text,
PRIMARY KEY ((tenant, id), property, timestamp)
) WITH CLUSTERING ORDER BY (property DESC, timestamp DESC);

CREATE TABLE booking_orch.generic_audit_log (
id text,
time timestamp,
data text,
event text,
PRIMARY KEY ((id, time))
);

CREATE TABLE booking_orch.state_machines_metadata (
tenant text,
program text,
sub_program text,
version int,
key text,
content text,
PRIMARY KEY ((tenant, program, sub_program, version, key))
);

CREATE TABLE booking_orch.lookup (
tenant text,
entity_type text,
external_entity_type text,
external_entity_value uuid,
created_at timeuuid,
entity_value uuid,
metadata map<text, text>,
PRIMARY KEY ((tenant, entity_type, external_entity_type, external_entity_value), created_at)
) WITH CLUSTERING ORDER BY (created_at ASC);

CREATE TABLE booking_orch.orders_pending_driver_allot (
tenant text,
time_part text,
yard_id text,
order_id uuid,
status text,
PRIMARY KEY ((tenant, time_part, yard_id), order_id)
) WITH CLUSTERING ORDER BY (order_id ASC);

CREATE TABLE booking_orch.get_check_log (
year int,
month int,
day int,
hour int,
status text,
order_id uuid,
time timestamp,
fp_bapi_response text,
oms_response text,
PRIMARY KEY ((year, month, day, hour, status, order_id, time))
);

CREATE TABLE booking_orch.payment_reconciliation (
tenant text,
status text,
request_api text,
order_id uuid,
timestamp timestamp,
request_data text,
PRIMARY KEY ((tenant, status, request_api), order_id, timestamp)
) WITH CLUSTERING ORDER BY (order_id DESC, timestamp DESC);

CREATE TABLE booking_orch.orders_by_pickup_time (
tenant text,
year int,
month int,
day int,
hour int,
min int,
order_id uuid,
data map<text, text>,
pickup_time timestamp,
PRIMARY KEY ((tenant, year, month, day, hour, min), order_id)
) WITH CLUSTERING ORDER BY (order_id ASC);

CREATE TABLE booking_orch.configs (
tenant text,
key text,
deleted int,
value text,
PRIMARY KEY ((tenant, key))
);

CREATE TABLE booking_orch.order_by_ext_ref_id (
tenant text,
ext_ref_id text,
order_id uuid,
PRIMARY KEY ((tenant, ext_ref_id))
);

CREATE TABLE booking_orch.state_machines (
tenant text,
program text,
sub_program text,
version int,
content text,
PRIMARY KEY ((tenant, program, sub_program, version))
);