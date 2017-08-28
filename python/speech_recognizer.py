import sys
import os
import json
import urllib.parse
import urllib.request

apikey = 'AIzaSyB4HQqiZ3uuVyhHTOoITpydT8lVzE4DBZg'
endpoint = 'http://www.google.com/speech-api/v2/recognize'
query_string = {'output': 'json', 'lang': 'en-US', 'key': apikey}

url = '{0}?{1}'.format(endpoint, urllib.parse.urlencode(query_string))

headers = {'Content-Type': 'audio/l16; rate=16000'}
voice_data = open(sys.argv[1], 'rb').read()

request = urllib.request.Request(url, data=voice_data, headers=headers)
response = urllib.request.urlopen(request).read()
str=response.decode('utf8')

# print all json
# print (str)

# extract first transcript
header='"transcript":"'
spos = str.find(header)
epos = str.find('"',len(header)+spos+1)
transcript = str[spos+len(header):epos]
print (transcript)

#for line in response.decode('utf-8').split():
#    if not line:
#        continue
#    else:
#        res = json.loads(line)
#        if res['result'] == []:
#            continue
#        else:
#            print(res)
