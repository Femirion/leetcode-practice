-- 175. Combine Two Tables
-- Runtime 455 ms Beats 37.39%
select p.firstName, p.lastName, a.city, a.state from Person p
    left join Address a on p.personId = a.personId;