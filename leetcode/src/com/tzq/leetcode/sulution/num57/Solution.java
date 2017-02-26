package com.tzq.leetcode.sulution.num57;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//¶ş·Ö²éÕÒ
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> inserted = new ArrayList<>();
		int pos = find(intervals, newInterval.start);
		for (int i = 0; i < pos; i++) {
			inserted.add(intervals.get(i));
		}
		if (pos > 0 && newInterval.start <= inserted.get(pos - 1).end) {
			inserted.get(pos - 1).end = Math.max(inserted.get(pos - 1).end,
					newInterval.end);
		} else {
			inserted.add(newInterval);
		}
		while (pos < intervals.size()
				&& intervals.get(pos).start <= inserted
						.get(inserted.size() - 1).end) {
			inserted.get(inserted.size() - 1).end = Math.max(
					inserted.get(inserted.size() - 1).end,
					intervals.get(pos).end);
			pos++;
		}
		for (int i = pos; i < intervals.size(); i++) {
			inserted.add(intervals.get(i));
		}
		return inserted;
	}

	private static int find(List<Interval> intervals, int start) {
		int i = 0, j = intervals.size() - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (intervals.get(m).start < start) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		return i;
	}
	
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 8));
		System.err.println(insert(intervals, new Interval(5, 6)));
	}
}
