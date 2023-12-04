#!/bin/bash
TEST=$1
cat input$TEST | cut -d: -f2 | cut -d\| -f1 > winning$TEST
cat input$TEST  | cut -d\| -f2 > mine$TEST
paste winning$TEST mine$TEST > winning_mine$TEST
cat winning_mine$TEST | xargs -I {} sh ./nsrt.sh {} > winning_mine_nsrt$TEST
cat winning_mine$TEST | xargs -I {} sh ./srt.sh {} > winning_mine_srt$TEST
paste winning_mine_nsrt$TEST winning_mine_srt$TEST  | awk '{ sum = $1 - $2; print 2^(sum-1) }' | sed -e's/0,5/0/' > card_points$TEST
cat card_points$TEST | paste -sd+ | bc


