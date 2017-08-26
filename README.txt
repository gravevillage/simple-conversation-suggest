対話プログラム
==============

本プログラムは、ある文書に対する応答分を作成する。言語は問わない。

## 利用方法
下記のファイルをコマンド実行フォルダに配置して実行する。

* 辞書ファイル: dict.txt
* 応答ファイル: res.txt

辞書ファイルには、質問文を、応答ファイルには回答文を1行づつ記述する。

## 実行方法

simple-converstation-suggestディレクトリで下記のコマンドを実行する。

    $ java -classpath "lib/lucene-analyzers-3.6.2.jar;lib/lucene-spellchecker-3.6.2.jar;lib/lucene-core-3.6.2.jar;build/classes/java/main;." Matcher "<質問文>"


run.sh(bash)、run.bat(Windowsコンソール)用のスクリプトを利用する場合は、それぞれ次の通り。

    $ ./run.sh "<質問文>"

    > run.bat "<質問文>"