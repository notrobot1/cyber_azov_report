# cyber_azov_report
#Report by virus file cyber_azov.apk

## Foreword
I found this  [report](https://blog.google/threat-analysis-group/continued-cyber-activity-in-eastern-europe-observed-by-tag/) from Google TAG. 
The report states that russian hackers created fake application for Dos attacks witch russian infrastructures. Application was distributed on fake site regiment "Azov". 
Today site down but we can see it on [web archive](https://web.archive.org/web/20220616174628/https://cyberazov.com/). 

If write a request in google "cyber azov" we can find [news posts](http://web.archive.org/web/20220727182903/https://tech.liga.net/other/novosti/rossiyskie-hakery-sozdali-feykovoe-prilojenie-kiber-azov-yakoby-dlya-kiberatak-na-rossiyu) which states russian hackers was collect geo data ukraine users who installed this application.
In this report we learn why it's not true.

# Lets start
Im downloaded file "cyber_azov.apk" and open it in jadx. Project file you can see in this repozitorie. 
First I analyzed file manifest where I learned what application can do in my phone.

We [can see](https://github.com/notrobot1/cyber_azov_report/blob/main/CyberAzov/AndroidManifest.xml) 4 permissions: 
* NETWORK_STATE; 
* INTERNET;
* and two permissions which not used in program (I failed spot this permissions in source code). 
```
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.USE_BIOMETRIC"/>
    <uses-permission android:name="android.permission.USE_FINGERPRINT"/>
 ```

At this time we can assert that application have not permissions collect geo data. But lets see what application send to server. I hook to function wich connect to server and replace cyberazov[.]com on my  ip. Now all request send be in my web server and I can see all request from application.

![requests](https://github.com/notrobot1/cyber_azov_report/blob/main/photo_5393499229307125549_y.jpg "")
On the screenshot we can see http request on which you can see that it not have POST or GET parameters. We get base64 string in response, I'm tryed decode this string but it ended in failure.

Example base64 code you can see here:
![requests](https://github.com/notrobot1/cyber_azov_report/blob/main/base.jpg "Example base64 code you can see here")

In source code, I discaver see hash function. This function decrypt base64 to json format. So I hooked  this function with the help of Frida and printed return to console.

![requests](https://github.com/notrobot1/cyber_azov_report/blob/main/return%20from%20server.jpg "")

__The application receives a target for attacks from the server, so hackers can change the target on Ukrainian sites at any time.(bold)__

# Does the application cope with the main task?

If we press button ">Start attack" and look on web traffic, we can see that application really send request to get target. But most of sites from target list blocked on the territory of Ukraine. Same way the number of requests casts doubt on the effectiveness of such an attack.

# Why was this app created?

Because the application does not cope with the task, there is only one reason for the existence of this product - the collection of donations.
On the site cuberazov[.]com we can see bitcoin purse for donations. I looked how many people sent cash at this purse and happy discover, that with this task application also does not managed.

![](https://github.com/notrobot1/cyber_azov_report/blob/main/Screenshot%202022-07-21%20at%2006-55-32%20Blockchain.com%20Explorer%20BTC%20ETH%20BCH.png "")
