package com.pot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.service.GoEasyPush;
import com.pot.socket.SocketInfoReader;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class SendPythonCode extends HttpServlet {

	private Socket socket;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码文件格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Socket connection = SocketThread.socket;

		if (connection!=null) {
			//启动数据读写处理线程

			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.setRequest(request);
			socketOperate.start();

			//启动写线程，向Socket写入判断返回数据指令
			SocketInfoWriter writer = new SocketInfoWriter(connection);
			
			writer.setInfo("3\r\n" + 
					"from lcd import LCD\r\n" + 
					"\r\n" + 
					"import RPi.GPIO as GPIO\r\n" + 
					"\r\n" + 
					"from teperater import Temperater\r\n" + 
					"\r\n" + 
					"from pcf8591 import Pressure\r\n" + 
					"\r\n" + 
					"from weight import Weight\r\n" + 
					"\r\n" + 
					"from time import sleep, ctime\r\n" + 
					"\r\n" + 
					"import sched,time\r\n" + 
					"\r\n" + 
					"import socket ##for socket\r\n" + 
					"\r\n" + 
					"import time\r\n" + 
					"\r\n" + 
					"import json\r\n" + 
					"\r\n" + 
					"import sys ##for exit | \\\r\n" + 
					"\r\n" + 
					" \r\n" + 
					"\r\n" + 
					"import threading\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"control = {'start': False, 'mode': 0, 'keepTem': 0, 'lowTem': 0, 'highTem': 0, 'status': 0}\r\n" + 
					"\r\n" + 
					"data_send={'temp':'', 'weight':'', 'pre':'', 'time':''}\r\n" + 
					"\r\n" + 
					"lcd = LCD()\r\n" + 
					"\r\n" + 
					"def temperter(device):\r\n" + 
					"\r\n" + 
					"    temp= Temperater()\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        tem = temp.read_temp(device)\r\n" + 
					"\r\n" + 
					"        data_send['temp'] = tem\r\n" + 
					"\r\n" + 
					"        #print(\"%s = %s\\t\" %(\"temp\"+device,tem)) \r\n" + 
					"\r\n" + 
					"##        print(ctime())\r\n" + 
					"\r\n" + 
					"        sleep(1)\r\n" + 
					"\r\n" + 
					"def pressure():\r\n" + 
					"\r\n" + 
					"    pre = Pressure()\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        pressureValue = pre.read_pressure()\r\n" + 
					"\r\n" + 
					"        data_send['pre'] = pressureValue\r\n" + 
					"\r\n" + 
					"        #print(\"pressure: %s\"%pressureValue)\r\n" + 
					"\r\n" + 
					"##        print(\"AOUT:%1.3f\" % pressureValue)\r\n" + 
					"\r\n" + 
					"        sleep(1)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"def weight():\r\n" + 
					"\r\n" + 
					"    we = Weight()\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        wei = we.read_weight()\r\n" + 
					"\r\n" + 
					"        data_send['weight'] = wei\r\n" + 
					"\r\n" + 
					"        #print(\"Weight: %s g\" %wei)\r\n" + 
					"\r\n" + 
					"        sleep(1)\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"def show():\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        if control['start'] == True:\r\n" + 
					"\r\n" + 
					"            \r\n" + 
					"\r\n" + 
					"            sleep(1)\r\n" + 
					"\r\n" + 
					"            status = control['status']\r\n" + 
					"\r\n" + 
					"            temp = data_send['temp']\r\n" + 
					"\r\n" + 
					"            press = data_send['pre']\r\n" + 
					"\r\n" + 
					"            wei = data_send['weight']\r\n" + 
					"\r\n" + 
					"            print('--------------------------')\r\n" + 
					"\r\n" + 
					"            if status == 1:\r\n" + 
					"\r\n" + 
					"                value = str(temp)+'          '\r\n" + 
					"\r\n" + 
					"                lcd.CleanScreen()\r\n" + 
					"\r\n" + 
					"                lcd.show(\"temperature       \",value)\r\n" + 
					"\r\n" + 
					"            elif status == 2:\r\n" + 
					"\r\n" + 
					"                print(\"xingbuxing\")\r\n" + 
					"\r\n" + 
					"                press = str(press)\r\n" + 
					"\r\n" + 
					"                lcd.show('pressure        ',press)\r\n" + 
					"\r\n" + 
					"            elif status == 3:\r\n" + 
					"\r\n" + 
					"                wei = str(wei)\r\n" + 
					"\r\n" + 
					"                lcd.show('weight          ',wei)\r\n" + 
					"\r\n" + 
					"            elif status == 4:\r\n" + 
					"\r\n" + 
					"                timer = control['highTem'] + control['lowTem'] + control['keepTem']\r\n" + 
					"\r\n" + 
					"                second = round(timer % 60)\r\n" + 
					"\r\n" + 
					"                minite = (timer // 60) % 60\r\n" + 
					"\r\n" + 
					"                hour = timer // 3600\r\n" + 
					"\r\n" + 
					"                lcd.show('timer          ','%s : %s : %s        '%(hour, minite, second))\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"def heat():\r\n" + 
					"\r\n" + 
					"    HIGHTEM = 16\r\n" + 
					"\r\n" + 
					"    LOWTEM = 20\r\n" + 
					"\r\n" + 
					"    KEEPTEM = 21\r\n" + 
					"\r\n" + 
					"    channels = [HIGHTEM, LOWTEM, KEEPTEM]\r\n" + 
					"\r\n" + 
					"    #GPIO.setwarnings(False)\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        highTem = control['highTem']\r\n" + 
					"\r\n" + 
					"        lowTem = control['lowTem']\r\n" + 
					"\r\n" + 
					"        keepTem = control['keepTem']\r\n" + 
					"\r\n" + 
					"        timer = keepTem + lowTem + highTem\r\n" + 
					"\r\n" + 
					"        GPIO.setmode(GPIO.BCM)\r\n" + 
					"\r\n" + 
					"        if timer > 0:    \r\n" + 
					"\r\n" + 
					"            if  highTem > 0:\r\n" + 
					"\r\n" + 
					"                GPIO.setup(HIGHTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                GPIO.output(HIGHTEM, GPIO.HIGH)\r\n" + 
					"\r\n" + 
					"                control['highTem'] = control['highTem'] - 1\r\n" + 
					"\r\n" + 
					"                sleep(1)\r\n" + 
					"\r\n" + 
					"            elif highTem == 0:\r\n" + 
					"\r\n" + 
					"                GPIO.setup(HIGHTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                GPIO.output(HIGHTEM, GPIO.LOW)\r\n" + 
					"\r\n" + 
					"                if lowTem > 0:\r\n" + 
					"\r\n" + 
					"                    GPIO.setup(LOWTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                    GPIO.output(LOWTEM, GPIO.HIGH)\r\n" + 
					"\r\n" + 
					"                    control['lowTem'] = control['lowTem'] - 1\r\n" + 
					"\r\n" + 
					"                    sleep(1)\r\n" + 
					"\r\n" + 
					"                elif lowTem == 0:\r\n" + 
					"\r\n" + 
					"                    GPIO.setup(LOWTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                    GPIO.output(LOWTEM, GPIO.LOW)\r\n" + 
					"\r\n" + 
					"                    if keepTem > 0:\r\n" + 
					"\r\n" + 
					"                        GPIO.setup(KEEPTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                        GPIO.output(KEEPTEM, GPIO.HIGH)\r\n" + 
					"\r\n" + 
					"                        control['keepTem'] = control['keepTem'] - 1\r\n" + 
					"\r\n" + 
					"                        sleep(1)\r\n" + 
					"\r\n" + 
					"                    elif keepTem:\r\n" + 
					"\r\n" + 
					"                        GPIO.setup(KEEPTEM, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"                        GPIO.output(KEEPTEM, GPIO.LOW)\r\n" + 
					"\r\n" + 
					"                    \r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"def send_data(current):\r\n" + 
					"\r\n" + 
					"    socket_tcp.send(bytes(current,encoding = 'utf-8'))\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"def communicate():\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    SERVER_IP = \"172.20.10.6\"\r\n" + 
					"\r\n" + 
					"    SERVER_PORT = 5000\r\n" + 
					"\r\n" + 
					"    server_addr = (SERVER_IP,SERVER_PORT)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"##ceate an AF_INET,STREAM socket (TCP)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    print(\"starting socket create\")\r\n" + 
					"\r\n" + 
					"    try:\r\n" + 
					"\r\n" + 
					"        socket_tcp = socket.socket(socket.AF_INET,socket.SOCK_STREAM)\r\n" + 
					"\r\n" + 
					"    except socket.error.msg:\r\n" + 
					"\r\n" + 
					"        print('Failed to creat socket. Error code: ' + str(msg[0]) + ', Error message : ' + msg[1])\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"    print(\"Socket Created\")\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        try:\r\n" + 
					"\r\n" + 
					"            print(\"Connecting to server @ %s:%d...\" %server_addr)\r\n" + 
					"\r\n" + 
					"            socket_tcp.connect(server_addr)\r\n" + 
					"\r\n" + 
					"            break\r\n" + 
					"\r\n" + 
					"        except Exception:\r\n" + 
					"\r\n" + 
					"            print(\"Can't connect to server, try it latter!\")\r\n" + 
					"\r\n" + 
					"            #time.sleep(0.01)\r\n" + 
					"\r\n" + 
					"            continue\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    print(\"Receiving package...\")\r\n" + 
					"\r\n" + 
					"##with open('/home/pi/Atest/data/data_send', 'r',  encoding = 'utf-8') as rec_file:\r\n" + 
					"\r\n" + 
					"##    for rec_line in rec_file:\r\n" + 
					"\r\n" + 
					"##        #send_line = json.dumps(rec_line).strip('\\n')\r\n" + 
					"\r\n" + 
					"##        socket_tcp.send(bytes(rec_line, encoding = 'utf-8'))\r\n" + 
					"\r\n" + 
					"#socket_tcp.send(bytes('client:)\\n',encoding = 'utf-8'))\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    while True:\r\n" + 
					"\r\n" + 
					"        try:\r\n" + 
					"\r\n" + 
					"            print(\"hua\")\r\n" + 
					"\r\n" + 
					"            data = str(socket_tcp.recv(1024),encoding = 'utf-8').strip( )\r\n" + 
					"\r\n" + 
					"            data = data.split('\\n')\r\n" + 
					"\r\n" + 
					"            flag = data[0].strip( )\r\n" + 
					"\r\n" + 
					"            data.remove(data[0])\r\n" + 
					"\r\n" + 
					"##            data_rec = str(socket_tcp.recv(1024),encoding = 'utf-8'),strip( )\r\n" + 
					"\r\n" + 
					"##            print('laji')\r\n" + 
					"\r\n" + 
					"##            data_rec = data_rec.split('\\n')\r\n" + 
					"\r\n" + 
					"##            flag = data_rec[0].strip( )\r\n" + 
					"\r\n" + 
					"##            data_rec.remove(data_rec[0])\r\n" + 
					"\r\n" + 
					"##        \r\n" + 
					"\r\n" + 
					"            print(flag)\r\n" + 
					"\r\n" + 
					"            if flag == '1':\r\n" + 
					"\r\n" + 
					"                print('comeo n')\r\n" + 
					"\r\n" + 
					"##                data_rec = data_rec[0]\r\n" + 
					"\r\n" + 
					"##                data_rec = json.loads(data_rec)\r\n" + 
					"\r\n" + 
					"##                pre = data_rec['pre']\r\n" + 
					"\r\n" + 
					"##                temp = data_rec['temp']\r\n" + 
					"\r\n" + 
					"##                time = data_rec['time']\r\n" + 
					"\r\n" + 
					"##                print('---%s---%s---%s---'%(pre,temp,time))\r\n" + 
					"\r\n" + 
					"                \r\n" + 
					"\r\n" + 
					"            elif flag == '2':\r\n" + 
					"\r\n" + 
					"                data_rec = data_rec[0]\r\n" + 
					"\r\n" + 
					"                data_rec = json.loads(data_rec)\r\n" + 
					"\r\n" + 
					"                data_key = sorted(data_rec.keys())\r\n" + 
					"\r\n" + 
					"                data_value=[]\r\n" + 
					"\r\n" + 
					"                for key in data_key:\r\n" + 
					"\r\n" + 
					"                    data_value.append(data_rec[key])\r\n" + 
					"\r\n" + 
					"                print(data_key)\r\n" + 
					"\r\n" + 
					"                print(data_value)\r\n" + 
					"\r\n" + 
					"            elif flag == '3':\r\n" + 
					"\r\n" + 
					"                print('dggs')\r\n" + 
					"\r\n" + 
					"                with open('/home/pi/Atest/data/data_rec', 'w',  encoding = 'utf-8') as rec_file:\r\n" + 
					"\r\n" + 
					"                    for line in data_rec:\r\n" + 
					"\r\n" + 
					"                        rec_file.write(line)\r\n" + 
					"\r\n" + 
					"        \r\n" + 
					"\r\n" + 
					"            elif flag == '4':\r\n" + 
					"\r\n" + 
					"                data_rec = 'd'\r\n" + 
					"\r\n" + 
					"            elif flag == '5':\r\n" + 
					"\r\n" + 
					"                print('come on')\r\n" + 
					"\r\n" + 
					"                current = str(data_send) +' \\r'\r\n" + 
					"\r\n" + 
					"                print(current)\r\n" + 
					"\r\n" + 
					"                socket_tcp.send(bytes(current,encoding = 'utf-8'))\r\n" + 
					"\r\n" + 
					"                print('----------------------------')\r\n" + 
					"\r\n" + 
					"                \r\n" + 
					"\r\n" + 
					"            \r\n" + 
					"\r\n" + 
					"            else:\r\n" + 
					"\r\n" + 
					"                socket_tcp.send(bytes('error order',encoding = 'utf-8'))\r\n" + 
					"\r\n" + 
					"                print('error')\r\n" + 
					"\r\n" + 
					"        \r\n" + 
					"\r\n" + 
					"        except Exception:\r\n" + 
					"\r\n" + 
					"            socket_tcp.close()\r\n" + 
					"\r\n" + 
					"            socket_tcp = None\r\n" + 
					"\r\n" + 
					"            sys.exit(1)\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"threads = []\r\n" + 
					"\r\n" + 
					"t1 = threading.Thread(target = temperter, args = ('A'))\r\n" + 
					"\r\n" + 
					"threads.append(t1)\r\n" + 
					"\r\n" + 
					"t2 = threading.Thread(target = temperter, args = ('B'))\r\n" + 
					"\r\n" + 
					"threads.append(t2)\r\n" + 
					"\r\n" + 
					"t3 = threading.Thread(target = pressure)\r\n" + 
					"\r\n" + 
					"threads.append(t3)\r\n" + 
					"\r\n" + 
					"t4 = threading.Thread(target = weight)\r\n" + 
					"\r\n" + 
					"threads.append(t4)\r\n" + 
					"\r\n" + 
					"t5 = threading.Thread(target = communicate)\r\n" + 
					"\r\n" + 
					"threads.append(t5)\r\n" + 
					"\r\n" + 
					"t6 = threading.Thread(target = show)\r\n" + 
					"\r\n" + 
					"threads.append(t6)\r\n" + 
					"\r\n" + 
					"t7 = threading.Thread(target = heat)\r\n" + 
					"\r\n" + 
					"threads.append(t7)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"for t in threads:\r\n" + 
					"\r\n" + 
					"    t.setDaemon(True)\r\n" + 
					"\r\n" + 
					"    t.start()\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"SWITCH = 26\r\n" + 
					"\r\n" + 
					"COOK = 19\r\n" + 
					"\r\n" + 
					"TIMEPLUS = 13\r\n" + 
					"\r\n" + 
					"TIMEMINUS = 6\r\n" + 
					"\r\n" + 
					"SHOW = 5 \r\n" + 
					"\r\n" + 
					"ENABLE = 25\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"GPIO.setwarnings(False)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"while True:\r\n" + 
					"\r\n" + 
					"    GPIO.setmode(GPIO.BCM)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(SWITCH, GPIO.IN, pull_up_down=GPIO.PUD_UP)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(COOK, GPIO.IN, pull_up_down=GPIO.PUD_UP)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(TIMEPLUS, GPIO.IN, pull_up_down=GPIO.PUD_UP)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(TIMEMINUS, GPIO.IN, pull_up_down=GPIO.PUD_UP)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(SHOW, GPIO.IN, pull_up_down=GPIO.PUD_UP)\r\n" + 
					"\r\n" + 
					"    GPIO.setup(ENABLE, GPIO.OUT)\r\n" + 
					"\r\n" + 
					"    switch = GPIO.input(SWITCH)\r\n" + 
					"\r\n" + 
					"    cook = GPIO.input(COOK)\r\n" + 
					"\r\n" + 
					"    timeplus = GPIO.input(TIMEPLUS)\r\n" + 
					"\r\n" + 
					"    timeminus = GPIO.input(TIMEMINUS)\r\n" + 
					"\r\n" + 
					"    display = GPIO.input(SHOW)\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"\r\n" + 
					"    if switch == False:\r\n" + 
					"\r\n" + 
					"        print('hdfuiseh')\r\n" + 
					"\r\n" + 
					"        control['start'] = not control['start']\r\n" + 
					"\r\n" + 
					"        start = control['start']\r\n" + 
					"\r\n" + 
					"        print(start)\r\n" + 
					"\r\n" + 
					"        if start == True:\r\n" + 
					"\r\n" + 
					"            GPIO.output(ENABLE, GPIO.HIGH)\r\n" + 
					"\r\n" + 
					"        else:\r\n" + 
					"\r\n" + 
					"            GPIO.output(ENABLE, GPIO.LOW)\r\n" + 
					"\r\n" + 
					"    if cook == False:\r\n" + 
					"\r\n" + 
					"        print('cook')\r\n" + 
					"\r\n" + 
					"        if control['mode'] == 3:\r\n" + 
					"\r\n" + 
					"            control['mode'] = 0\r\n" + 
					"\r\n" + 
					"        control['mode'] = control['mode'] + 1\r\n" + 
					"\r\n" + 
					"    if timeplus ==  False:\r\n" + 
					"\r\n" + 
					"        if control['mode'] == 1:\r\n" + 
					"\r\n" + 
					"            control['keepTem'] = control['keepTem'] + 10\r\n" + 
					"\r\n" + 
					"        elif control['mode'] == 2:\r\n" + 
					"\r\n" + 
					"            control['lowTem'] = control['lowTem'] + 10\r\n" + 
					"\r\n" + 
					"        elif control['mode'] == 3:\r\n" + 
					"\r\n" + 
					"            control['highTem'] = control['highTem'] + 10\r\n" + 
					"\r\n" + 
					"    if timeminus ==  False:\r\n" + 
					"\r\n" + 
					"        if control['mode'] == 1:\r\n" + 
					"\r\n" + 
					"            control['keepTem'] = control['keepTem'] - 10\r\n" + 
					"\r\n" + 
					"        elif control['mode'] == 2:\r\n" + 
					"\r\n" + 
					"            control['lowTem'] = control['lowTem'] - 10\r\n" + 
					"\r\n" + 
					"        elif control['mode'] == 3:\r\n" + 
					"\r\n" + 
					"            control['highTem'] = control['highTem'] - 10\r\n" + 
					"\r\n" + 
					"    if display == False:\r\n" + 
					"\r\n" + 
					"        print('ooooooo')\r\n" + 
					"\r\n" + 
					"        if control['status'] == 4:\r\n" + 
					"\r\n" + 
					"            control['status'] = 0\r\n" + 
					"\r\n" + 
					"        control['status'] = control['status'] + 1\r\n" + 
					"\r\n" + 
					"    sleep(0.2)");
			
//			// read file content from file
//            StringBuffer sb= new StringBuffer("");
//            File file = new File("D:\\code.txt");
//            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
//            BufferedReader br = new BufferedReader(reader);
//            String str = null;
//            while((str = br.readLine()) != null) {
//            	str += "\n";
//            	System.out.println("里面" + str);
//            }
//			System.out.println("外面" + str);
//			writer.setInfo(str);
//            br.close();
//            reader.close();


//			SocketInfoReader readers = new SocketInfoReader(connection);
//			String infos = readers.getInfo();
//			System.out.println("获取到的返回值为" + infos);
//			if(infos != null) {
//
//			}
		

			
		}
		
		
	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
