/*******************************************************************************
 * Copyright [2018] [Haiyang Sun, Università della Svizzera Italiana (USI)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ch.usi.inf.nodeprof.test.examples.report;

import java.util.HashMap;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class ReportDB {
    public static interface ReportFactory {
        Report create(long iid);
    }

    private final HashMap<Long, Report> records = new HashMap<>();

    @TruffleBoundary
    public Report get(Long entryKey) {
        return records.get(entryKey);
    }

    @TruffleBoundary
    public Report put(Long entryKey, Report value) {
        return records.put(entryKey, value);
    }

    @TruffleBoundary
    public void remove(Long key) {
        records.remove(key);
    }

    @TruffleBoundary
    public boolean contains(Long key) {
        return records.containsKey(key);
    }

    public HashMap<Long, Report> getRecords() {
        return records;
    }

    @TruffleBoundary
    public void clear() {
        this.records.clear();
    }
}