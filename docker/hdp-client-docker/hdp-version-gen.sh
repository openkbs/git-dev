#!/bin/bash -x

#### ---- print Hadoop HDP Version info ----
hdp-select status hadoop-client|awk '{print $3}'
