scp User.java spawar2@remote.eos.ncsu.edu:/afs/unity.ncsu.edu/users/s/spawar2
scp Wolfcity.java spawar2@remote.eos.ncsu.edu:/afs/unity.ncsu.edu/users/s/spawar2
scp Queries.java spawar2@remote.eos.ncsu.edu:/afs/unity.ncsu.edu/users/s/spawar2


To connect local mariadb
sudo mysql -u root -p -h localhost

password - test

To get sql dump
mysqldump -u atiwari4 -p -h classdb2.csc.ncsu.edu atiwari4 > atiwari4.sql 

scp from remote to local

scp  spawar2@remote.eos.ncsu.edu:/afs/unity.ncsu.edu/users/s/spawar2/atiwari4.sql  db.sql

scp  spawar2@remote-linux.eos.ncsu.edu:/afs/​unity.ncsu.edu/users/s/spawar2/db.sql  db_local.sql

rsync -avzh --stats --progress spawar2@remote.eos.ncsu.edu:/afs/unity.ncsu.edu/users/s/spawar2/atiwari4.sql  / 
