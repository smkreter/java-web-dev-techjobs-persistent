## Part 1: Test it with SQL
-- PART 1
select * from job

## Part 2: Test it with SQL
select name from employer
where location = "St. Louis"

## Part 3: Test it with SQL

truncate job;

## Part 4: Test it with SQL

select name, description
from skill
join job_skills
on skill.id=job_skills.skills_id
order by name;
