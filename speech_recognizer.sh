
/c/Program\ Files\ \(x86\)/sox-14-4-2/sox.exe -t waveaudio --encoding signed-integer --bits 16 --channels 1 --rate 16000 -d $1&

PID=$!

sleep 5

kill $PID
