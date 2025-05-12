-- 182. Duplicate Emails

-- Runtime 202 ms Beats 95.37%
-- Memory 0.00 MB Beats 100.00%
select email from Person
    group by email
    having count(email) > 1