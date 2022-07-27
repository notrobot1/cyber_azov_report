# cyber_azov_report
#Report by virus file cyber_azov.apk

## Foreword
I found this  [report](https://blog.google/threat-analysis-group/continued-cyber-activity-in-eastern-europe-observed-by-tag/) from Google TAG. 
The report states that russian hackers created fake application for Dos attacks witch russian infrastructures. Application was distributed on fake site regiment "Azov". 
Today site down but we can see it on [web archive](https://web.archive.org/web/20220616174628/https://cyberazov.com/). 

If write request in google "cyber azov" we can find [news posts](http://web.archive.org/web/20220727182903/https://tech.liga.net/other/novosti/rossiyskie-hakery-sozdali-feykovoe-prilojenie-kiber-azov-yakoby-dlya-kiberatak-na-rossiyu) which states russian hackers was collect geo data ukraine users who installed this application.
In this report we learn why it's not true.

# Lets start
Im downloaded file "cyber_azov.apk" and open it in jadx. Project file you can see in this repozitorie. 
First I analyzed file manifest where I learned what application can do in my phone.

On screenshot we can see 4 permissions: 
* NETWORK_STATE; 
* INTERNET;
* and two permissions which not used in program (I failed spot this permissions in source code). 
screeen```````````

At this time we can assert that application have not permissions collect geo data. But lets see what application send to server. I hook to function wich connect to server and replace cyberazov[.]com on my  ip. Now all request send be in my web server and I can see all request from application.

screeen````````
On the screenshot we can see http request on which you can see that it not have POST or GET parameters. We get base64 string in response, I'm tryed decode this string but it ended in failure.

