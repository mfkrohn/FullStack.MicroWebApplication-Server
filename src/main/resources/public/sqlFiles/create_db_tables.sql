CREATE TABLE profile (
  profile_id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL
);

CREATE TABLE account (
  account_id SERIAL PRIMARY KEY,
  profile_id INTEGER NOT NULL,
  balance DOUBLE PRECISION NOT NULL,
  balance_history DOUBLE PRECISION[]
);