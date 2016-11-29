#!/bin/bash -x

#####################################################
#### ---- Install R with the latest version ---- ####
#####################################################

#Remove R old version
sudo apt-get remove r-base-core 
sudo apt-get remove r-base
sudo apt-get autoremove

codename=$(lsb_release -c -s)  
echo "deb http://ftp.iitm.ac.in/cran/bin/linux/ubuntu $codename/" | sudo tee -a /etc/apt/sources.list > /dev/null  

#Note that instead of http://ftp.iitm.ac.in/cran one must replace it with the geographically closest CRAN mirror. Also, the Ubuntu archives on CRAN are signed with the key of Michael Rutter <marutter@gmail> with key ID E084DAB9. So we type in the following:

sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E084DAB9  
sudo add-apt-repository ppa:marutter/rdev

#Followed by what we would normally have done:

sudo apt-get update -y
sudo apt-get upgrade -y
sudo apt-get install r-base r-base-dev r-base-core

sudo apt-get install -y libssl-dev
sudo apt-get install -y libcurl
sudo apt-get install -y libcurl4-openssl-dev
