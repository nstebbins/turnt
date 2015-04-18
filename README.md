# turnt
turn-based programming language

### install
we use [antlr 4.5](http://www.antlr.org/), which is compatible with both **OS X** and the **CLIC** machines. to set up for **OS X**, run:
```bash
cd /usr/local/lib
sudo curl -0 http://www.antlr.org/download/antlr-4.5-complete.jar
```
### run
to run the commands in `src/Makefile`, add the following to `~/.bash_profile` (**OS X**) or `~/.bashrc` (**Linux**):
```bash
export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
alias antlr4='java -jar /usr/local/lib/antlr-4.5-complete.jar'
alias grun='java org.antlr.v4.runtime.misc.TestRig'
```
to build and run:
```bash
make # builds the translator and translates test.tt
java Main # runs the translated program
```
### file structure
* `src`: primary directory; contains up-to-date grammar and translator code
* `test`: contains basic unit-testing structure for translator
* `template`: contains the base and target code for "Hello World"
* `testbasic`: basic ANTLR "Hello World"; helpful to use for ANTLR install debugging
* `doc`: documentation, which for now only includes project proposal
