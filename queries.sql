-- Part 1: Test it with SQL
-- id: Integer (Auto-generated, primary key)
-- name: Text/String
-- employer: Text/String
-- skills: Text/String
-- Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St. Louis City";
-- Part 3: Test it with SQL
DROP TABLE job;
-- Part 4: Test it with SQL
SELECT skill.name
FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY skill.name ASC;
