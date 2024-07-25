mysql root로 로그인 후

mysql > show global variables like 'log_bin_trust_function_creators';

 -> log_bin_trust_function_creators => off

mysql> set global log_bin_trust_function_creators=ON;
