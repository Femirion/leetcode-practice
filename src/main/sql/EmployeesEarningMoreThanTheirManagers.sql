-- 181. Employees Earning More Than Their Managers


-- Runtime 2569 ms Beats 5.01%
select e.name as Employee from Employee e where
        e.salary > (select m.salary from Employee m where m.id = e.managerId)



-- Runtime 397 ms Beats 57.57%
select e.name as Employee from Employee e
    inner join Employee m on e.managerId = m.id
    where e.salary > m.salary;