# Write your MySQL query statement below
SELECT  customer_id,
count(visit_id) as count_no_trans
from 
 Visits
where
  Visit_id  NOT in (select 
  visit_id
  from 
  Transactions
  )
  Group by
  customer_id