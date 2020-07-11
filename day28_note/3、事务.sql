1、事务：
	事务是表示一组操作要么同时成功，要么同时失败，而且事务与事务之间是独立。
	事务有ACID的特性。
	（1）原子性（2）一致性（3）隔离性（4）持久性
	
银行转账

	张三-》李四转账500元
	张三原来的余额是1000元，
	李四原来的余额是0元。
	
	（1）张三账户-500
	（2）李四账户+500
	
	一致性：要么张三还是1000，李四是0
		    要么张三现在是500，李四是500
			
	张三-500成功了，要给李四+500时，发现李四的账号异常，那么要回滚，还原刚刚张三-500的操作。
	如果都成功了，就提交。
	
事务：
	网购，下订单
	
	（1）创建订单--》订单表中要添加记录
	（2）记录订单明细--》订单明细表中要添加订单都买了什么
	（3）商品表修改-->库存量修改，销量增量	

2、
mysql默认是自动提交事务，一句SQL是一个事务，执行成功一句就提交一句。

手动开始事务，取消自动提交。
方式一：
set autocommit = false;
	这次客户端连接，在你恢复自动提交之前，
	接下来所有的SQL执行都必须手动提交了，否则就不生效。
	
这个设置只管一个连接，和其他的连接（登录）无关。	
set autocommit = false;
....   都是需要手动提交的。
set autocommit = true;	


当只是部分的SQL需要构成事务，手动提交，而其他SQL还是想要自动提交的。
那么我们选择方式二。

方式二：
start transaction;
....   一个事务
commit;或rollback;

start transaction;
....   另一个事务
commit;或rollback;

...    自动提交


3、事务的隔离级别
同一个库的同一个表同一个记录，对于多个事务来说，就是共享数据。
多个事务被多个线程同时执行时，那么共享数据就会线程安全问题。


针对不同安全级别的要求，设置了不同的隔离级别：
（1）read uncommitted：可以读取未提交的
		事务1，可以读取到事务2已经修改，但是还没正式提交的数据
		会出现脏读、不可重复读、幻读
（2）read committed：读取已提交的数据
		事务1，只能读取到事务2已提交的数据
		会出现不可重复读、幻读
（3）repeatable READ：
		原来：会出现幻读
		现在：幻读也可以避免
		行锁
（4）Serializable
		所有问题都可以避免。
		表锁
		
几种问题：
（1）脏读现象
	事务1对某个记录进行修改，还未提交。事务2就看到了。
	那么这个被事务1修改还未提交的数据就是脏数据。
	
	如何避免脏读，把事务隔离级别设置为（2）（3）（3）都可以避免。
（2）不可重复的
	事务1对某个表进行修改，已经提交。
	但是事务2，在事务1提交之前，查询了一下这个记录，
	          在事务1提交之后，又查询了一下这个记录，
		对于事务2来说，出现了不可重复读的现象。
		在同一个事务中，前后两次对同一个记录的读取发现不一样。
	如果想要避免不可重复读，那么需要设置隔离级别为（3）（4）	
	
（3）幻读
	事务1给某个表增加了新的记录，或者删除了某个表的记录。（记录数有变化）
	并且提交了。
	事务2，在事务1提交之前，查询了这个表
	          在事务1提交之后，查询了这个表
			对于事务2来说，前后两次的记录数不一样。好比出现幻觉一样。多出或少了记录。
			
	如果想要避免幻读，那么需要设置隔离级别为（4）。
	但是mysql在5.0之后，升级了。在隔离级别（3）的时候，就可以避免幻读了。

4、如何查询当前连接是什么隔离级别
mysql默认的隔离级别是：
+-----------------+
| @@tx_isolation  |
+-----------------+
| REPEATABLE-READ |
+-----------------+

用户要查看的话：select @@tx_isolation;

5、如何修改当前连接的隔离级别
set tx_isolation = 'read-uncommitted';
set tx_isolation = 'read-committed';
set tx_isolation = 'REPEATABLE-READ';
set tx_isolation = 'serializable';